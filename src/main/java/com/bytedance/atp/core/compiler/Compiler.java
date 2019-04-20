package com.bytedance.atp.core.compiler;

import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.domain.model.common.FlowMeddleEvent;
import com.bytedance.atp.common.Tuple2;
import com.bytedance.atp.common.Tuple3;
import com.bytedance.atp.domain.model.group.RuleGroup;
import com.bytedance.atp.domain.model.runtime.*;
import com.bytedance.atp.common.Env;
import com.bytedance.atp.common.ExeStrategy;
import com.bytedance.atp.common.Rule;
import com.bytedance.atp.common.State;
import io.reactivex.Flowable;
import io.reactivex.processors.PublishProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 规则引擎编译器
 *
 * 将静态的RuleGroup & ConfigCenter 编译为 Flow
 *
 * PS: Flow为Runtime概念，它携带所有编译后的信息，比如执行器、执行参数、执行规则等等
 *     Flow的执行阶段不会再依赖任何静态资源
 *
 * 该编译器里的转换操作，使用的是Visitor设计模式（见Visitor接口）,包括参数检查、执行器选取（初始化出operator）
 */

@Component
public class Compiler {
    @Autowired
    public ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister;

    //Hot Stream
    @Autowired
    public PublishProcessor<FlowMeddleEvent> meddle;

    @Autowired
    public ApplicationEventPublisher bus;

    /**
     * 编译器核心方法，将静态资源编译为Runtime的Flow
     */
    public Flow compile(Env env, ExeStrategy strategy, RuleGroup group, ConfigCenter center){

        OperatorChain chain = Flowable.fromIterable(group.rules)
                .map(rule -> Tuple2.<Rule, RuleValidator>apply(rule, ruleHandlerRegister.get(rule)))
                .map(ruleAndValidator -> Tuple3.apply(ruleAndValidator, center.obtainConfigPile(ruleAndValidator._1, env)))
                .map(ruleAndValidatorAndPile -> new Operator(ruleAndValidatorAndPile._1, ruleAndValidatorAndPile._2, ruleAndValidatorAndPile._3))
                .reduce(
                        OperatorChain.newInstance(),
                        (chains, operator) -> {
                            chains.last().setNext(Optional.of(operator));
                            return chains;
                        }
                ).blockingGet();


        //进行验证，参数验证

        return new Flow(
                group.id,
                env,
                State.READY,
                strategy,
                chain,
                meddle,
                bus);
    }


}
