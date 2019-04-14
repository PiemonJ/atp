package com.bytedance.atp;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        ConfigCenter configCenter = new ConfigCenter();
        configCenter.setRuleGroupId("1");
        configCenter.configApply(
                ConfigEnv.TEST,
                Arrays.asList(
                    Configer.builder().item(ConfigItem.CODE_COVERAGE).value(ConfigValue.apply("80%")).build()
                ));

        System.out.println(configCenter);
    }
}
