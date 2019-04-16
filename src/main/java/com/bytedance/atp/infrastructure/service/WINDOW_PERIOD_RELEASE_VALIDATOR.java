package com.bytedance.atp.infrastructure.service;

import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.*;
import com.bytedance.atp.domain.model.common.Tuple2;
import com.bytedance.atp.domain.model.common.Weekday;
import com.bytedance.atp.domain.model.group.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.awt.SystemColor.info;

@Component(value = "WINDOW_PERIOD_RELEASE_VALIDATOR")
public class WINDOW_PERIOD_RELEASE_VALIDATOR implements RuleValidator {

    @Autowired
    public WINDOW_PERIOD_RELEASE_VALIDATOR(ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister) {
        ruleHandlerRegister.put(Rule.WINDOW_PERIOD_RELEASE,this);
    }

    @Override
    public List<Tuple2<String, Boolean>> argsValidate(ConfigPile pile) {

        Configer<List<Weekday>> configer = pile.obtain(ConfigDescriptor.RELEASE_VALID_DAY);

        List<Weekday> weekdays = configer.obtainValue().get();

        return Arrays.asList(Tuple2.apply(ConfigDescriptor.RELEASE_VALID_DAY.getScalar().getDesc(),weekdays == null ? false : true));
    }

    @Override
    public Tuple2<Object, Boolean> ruleValidate(ConfigPile pile) {

        Calendar calendar = Calendar.getInstance();

        int week = calendar.get(Calendar.DAY_OF_WEEK);


        Configer<List<Weekday>> configer = pile.obtain(ConfigDescriptor.RELEASE_VALID_DAY);


        List<Weekday> weekdays = configer.obtainValue().get();

        System.out.println(weekdays.size());
        weekdays.stream()
                .forEach(x -> {
                    System.out.println(x.getCode() + ":" + x.getDesc());
                });

        boolean result = weekdays
                .stream()
                .anyMatch(weekday -> week == weekday.code);

        return Tuple2.apply(null,result);
    }

}
