package com.bytedance.atp.domain.model.cc;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ConfigCenterFactory {

    public static ConfigCenter buildConfigCenter(Env env, String ruleGroupId, Map<ConfigScalar,String> configers){

        ConfigCenter cc = new ConfigCenter();

        cc.setId(UUID.randomUUID().toString());

        cc.setVersion(0);

        cc.setRuleGroupId(ruleGroupId);

        cc.configApply(env,configers);

        return cc;

    }
}
