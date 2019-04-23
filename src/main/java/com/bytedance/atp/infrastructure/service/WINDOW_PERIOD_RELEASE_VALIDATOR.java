package com.bytedance.atp.infrastructure.service;

import com.bytedance.atp.common.*;
import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.*;
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

        Configer<Single<Tuple2<Timer, Timer>>> configer = pile.obtain(ConfigDescriptor.RELEASE_VALID_DAY);

        Single<Tuple2<Timer, Timer>> single = configer.obtainValue().get();

        return Arrays.asList(Tuple2.apply(ConfigDescriptor.RELEASE_VALID_DAY.getScalar().getDesc(),single.getValue() == null ? false : true));
    }

    @Override
    public Tuple2<Rule, Boolean> ruleValidate(ConfigPile pile) {

        Calendar now = Calendar.getInstance();

        Configer<Single<Tuple2<Timer, Timer>>> configer = pile.obtain(ConfigDescriptor.RELEASE_VALID_DAY);

        Single<Tuple2<Timer, Timer>> single = configer.obtainValue().get();

        Tuple2<Timer, Timer> timers = single.value;

        int week = now.get(Calendar.DAY_OF_WEEK);

        int hour = now.get(Calendar.HOUR_OF_DAY);

        boolean result = (timers._1.weekday.code == week && hour >= timers._1.from && hour < timers._1.to)
                            ||
                         (timers._2.weekday.code == week && hour >= timers._2.from && hour < timers._2.to);
        return Tuple2.apply(REFERENCE_RULE,result);

    }

}
