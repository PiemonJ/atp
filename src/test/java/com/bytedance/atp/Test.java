package com.bytedance.atp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bytedance.atp.domain.model.common.Weekday;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        String s = JSON.toJSONString(Arrays.asList(Weekday.FRI));
        System.out.println(s);

        Object o = JSON.parseObject("[\"TRU\"]", new TypeReference<List<Weekday>>() {
        }.getType());

        Object o1 = JSON.parseObject(s, new TypeReference<List<Weekday>>() {
        }.getType());


        ConfigCenter configCenter = new ConfigCenter();
        configCenter.setRuleGroupId("1");
        configCenter.configApply(
                ConfigEnv.TEST,
                Arrays.asList(
                    Configers.builder().item(ConfigItem.CODE_COVERAGE).value(ConfigValue.apply("80%")).build()
                ));

        System.out.println(configCenter);



    }
}
