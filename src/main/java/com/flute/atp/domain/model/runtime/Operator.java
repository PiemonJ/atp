package com.flute.atp.domain.model.runtime;

import com.flute.atp.common.VerificationReport;
import com.flute.atp.core.validator.RuleValidator;
import com.flute.atp.domain.model.cc.ConfigPile;
import com.flute.atp.common.Rule;
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

    public ConfigPile pile;

    public Optional<Operator> next;

    public static Operator thimble(){
        Operator operator = new Operator();
        operator.setNext(Optional.empty());
        return operator;
    }


    public Operator( Rule rule, RuleValidator validator, ConfigPile pile) {
        this.validator = validator;
        this.rule = rule;
        this.pile = pile;
        this.next = Optional.empty();
    }

    public VerificationReport action() {

        return validator.ruleValidate(pile);

    }
}
