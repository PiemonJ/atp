package com.flute.atp.infrastructure.service;

import com.flute.atp.common.Rule;
import com.flute.atp.common.Tuple2;
import com.flute.atp.common.VerificationReport;
import com.flute.atp.core.validator.RuleValidator;
import com.flute.atp.domain.model.cc.ConfigPile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component(value = "COVERAGE_VALIDATOR")
public class COVERAGE_VALIDATOR implements RuleValidator {

    public static final Rule REFERENCE_RULE = Rule.COVERAGE;

    @Autowired
    public COVERAGE_VALIDATOR(ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister) {
        ruleHandlerRegister.put(REFERENCE_RULE, this);
    }


    @Override
    public List<Tuple2<String, Boolean>> argsValidate(ConfigPile pile) {
        return null;
    }

    @Override
    public VerificationReport ruleValidate(ConfigPile pile) {
        return new VerificationReport();
    }
}
