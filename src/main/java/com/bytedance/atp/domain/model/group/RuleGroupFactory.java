package com.bytedance.atp.domain.model.group;

import java.util.List;

public class RuleGroupFactory {

    public static RuleGroup buildRuleGroup(String creator,String groupName,List<Rule> rules){

        GroupIdentifier groupIdentifier = new GroupIdentifier(creator, groupName);

        return new RuleGroup(groupIdentifier,rules);
    }
}
