package com.bytedance.atp.core.compiler;

import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.domain.model.common.FlowMeddleEvent;
import com.bytedance.atp.domain.model.common.Tuple2;
import com.bytedance.atp.domain.model.common.Tuple3;
import com.bytedance.atp.domain.model.group.Rule;
import com.bytedance.atp.domain.model.group.RuleGroup;
import com.bytedance.atp.domain.model.runtime.*;
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
    public Flow compile(ExeStrategy strategy, RuleGroup group, ConfigCenter center){


        OperatorChain chain = Flowable.fromIterable(group.rules)
                .map(rule -> Tuple2.apply(rule, ruleHandlerRegister.get(rule)))
                .map(ruleAndHandler -> Tuple3.apply(ruleAndHandler, center.obtainConfigInfo(ruleAndHandler._1.category)))
                .map(tuple3 -> new Operator(tuple3._1,tuple3._2,tuple3._3))
                .reduce(OperatorChain.newInstance(), (chains, operator) -> {
                    chains.last().setNext(Optional.of(operator));
                    return chains;
                }).blockingGet();

        //进行验证，参数验证

        return new Flow(strategy, State.READY,chain,meddle,bus);
    }


}
