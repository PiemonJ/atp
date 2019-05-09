package com.bytedance.atp.infrastructure.service;

import com.bytedance.atp.common.*;
import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.ConfigDescriptor;
import com.bytedance.atp.domain.model.cc.ConfigPile;
import com.bytedance.atp.domain.model.cc.Configer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component(value = "BRANCH_NAME_STANDARD_VALIDATOR")
public class BRANCH_NAME_STANDARD_VALIDATOR implements RuleValidator {

    public static final Rule REFERENCE_RULE = Rule.BRANCH_NAME_STANDARD;

    @Autowired
    public BRANCH_NAME_STANDARD_VALIDATOR(ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister) {
        ruleHandlerRegister.put(REFERENCE_RULE, this);
    }

    @Override
    public List<Tuple2<String, Boolean>> argsValidate(ConfigPile pile) {

        Configer<Single<BigDecimal>> configer = pile.obtain(ConfigDescriptor.CODE_OK_RATE);

        Single<BigDecimal> single = configer.obtainValue().get();


        return Arrays.asList(Tuple2.apply(ConfigDescriptor.RELEASE_VALID_DAY.getScalar().getDesc(), single.getValue() == null ? false : true));
    }

    @Override
    public VerificationReport ruleValidate(ConfigPile pile) {


        Configer<Single<BigDecimal>> configer = pile.obtain(ConfigDescriptor.CODE_OK_RATE);

        Single<BigDecimal> single = configer.obtainValue().get();

        //调用sat获取成功率

        boolean matched = true;

        return new VerificationReport(REFERENCE_RULE, single.value.toString(), BigDecimal.TEN.toString() , "分支名不符合命名规范", matched);

    }
}