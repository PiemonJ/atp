package com.bytedance.atp.domain.model.runtime;

import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.Info;
import com.bytedance.atp.domain.model.common.Tuple2;
import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

/**
 * 操作符
 * 对应的是一个测试度量的执行Runtime
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Operator {

    public RuleValidator validator;

    public Rule rule;

    public Info info;

    public Optional<Operator> next;

    public static Operator thimble(){
        Operator operator = new Operator();
        operator.setNext(Optional.empty());
        return operator;
    }


    public Operator( Rule rule, RuleValidator validator, Info info) {
        this.validator = validator;
        this.rule = rule;
        this.info = info;
    }

    public Tuple2<Object,Boolean> action() {

        return validator.validate(info);

    }
}
