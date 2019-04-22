package com.bytedance.atp.infrastructure.service;

import com.bytedance.atp.common.Rule;
import com.bytedance.atp.common.Tuple2;
import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.ConfigPile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component(value = "OK_RATE_VALIDATOR")
public class OK_RATE_VALIDATOR implements RuleValidator {

    public static final Rule REFERENCE_RULE = Rule.OK_RATE;

    @Autowired
    public OK_RATE_VALIDATOR(ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister) {
        ruleHandlerRegister.put(REFERENCE_RULE, this);
    }

    @Override
    public List<Tuple2<String, Boolean>> argsValidate(ConfigPile pile) {
        return null;
    }

    @Override
    public Tuple2 ruleValidate(ConfigPile pile) {
        return null;
    }
}
