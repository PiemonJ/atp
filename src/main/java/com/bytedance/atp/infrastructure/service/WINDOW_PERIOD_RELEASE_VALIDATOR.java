package com.bytedance.atp.infrastructure.service;

import com.bytedance.atp.common.DateInterval;
import com.bytedance.atp.common.Rule;
import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.*;
import com.bytedance.atp.common.Single;
import com.bytedance.atp.common.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component(value = "WINDOW_PERIOD_RELEASE_VALIDATOR")
public class WINDOW_PERIOD_RELEASE_VALIDATOR implements RuleValidator {

    public static final Rule REFERENCE_RULE = Rule.WINDOW_PERIOD_RELEASE;

    @Autowired
    public WINDOW_PERIOD_RELEASE_VALIDATOR(ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister) {
        ruleHandlerRegister.put(REFERENCE_RULE,this);
    }

    @Override
    public List<Tuple2<String, Boolean>> argsValidate(ConfigPile pile) {

        Configer<Single<DateInterval>> configer = pile.obtain(ConfigDescriptor.RELEASE_VALID_DAY);

        Single<DateInterval> single = configer.obtainValue().get();


        return Arrays.asList(Tuple2.apply(ConfigDescriptor.RELEASE_VALID_DAY.getScalar().getDesc(),single.getValue() == null ? false : true));
    }

    @Override
    public Tuple2<Rule, Boolean> ruleValidate(ConfigPile pile) {

        Calendar now = Calendar.getInstance();

        Configer<Single<DateInterval>> configer = pile.obtain(ConfigDescriptor.RELEASE_VALID_DAY);

        Single<DateInterval> singleDateInterval = configer.obtainValue().get();

        boolean within = singleDateInterval.value.within(now.getTime());

        return Tuple2.apply(REFERENCE_RULE,within);

    }

}
