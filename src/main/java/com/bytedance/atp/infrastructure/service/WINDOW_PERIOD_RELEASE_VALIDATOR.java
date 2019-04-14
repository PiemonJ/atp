package com.bytedance.atp.infrastructure.service;

import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.cc.Info;
import com.bytedance.atp.domain.model.cc.ReleaseInfo;
import com.bytedance.atp.domain.model.common.Tuple2;
import com.bytedance.atp.domain.model.common.Weekday;
import com.bytedance.atp.domain.model.group.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component(value = "WINDOW_PERIOD_RELEASE_VALIDATOR")
public class WINDOW_PERIOD_RELEASE_VALIDATOR implements RuleValidator<ReleaseInfo> {

    @Autowired
    public WINDOW_PERIOD_RELEASE_VALIDATOR(ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister) {
        ruleHandlerRegister.put(Rule.WINDOW_PERIOD_RELEASE,this);
    }

    @Override
    public List<Tuple2<String, Boolean>> argsValidate(Info info) {

        ReleaseInfo releaseInfo = (ReleaseInfo) info;

        List<Weekday> validReleaseDay = releaseInfo.getValidReleaseDay();
        if (validReleaseDay == null || validReleaseDay.size() == 0){
            return Arrays.asList(Tuple2.apply("validReleaseDay",false));
        }
        return Arrays.asList(Tuple2.apply("validReleaseDay",true));
    }

    @Override
    public Tuple2<Object, Boolean> ruleValidate(Info info) {

        Calendar calendar = Calendar.getInstance();

        int week = calendar.get(Calendar.DAY_OF_WEEK);

        ReleaseInfo releaseInfo = (ReleaseInfo) info;
        boolean result = releaseInfo.getValidReleaseDay()
                .stream()
                .anyMatch(weekday -> week == weekday.code);

        return Tuple2.apply(null,result);
    }
}
