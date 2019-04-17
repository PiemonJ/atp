package com.bytedance.atp.domain.model.group;

import java.util.List;
import java.util.UUID;

public class RuleGroupFactory {

    public static RuleGroup buildRuleGroup(String creator,String groupName,List<Rule> rules){

        GroupIdentifier groupIdentifier = new GroupIdentifier(creator, groupName);

        RuleGroup ruleGroup = new RuleGroup(groupIdentifier, rules);

        ruleGroup.setId(UUID.randomUUID().toString());

        ruleGroup.setVersion(0);

        return ruleGroup;
    }
}
