package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.common.Rule;
import com.bytedance.atp.domain.model.group.event.RuleGroupCreatedEvent;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class RuleGroupFactory {

    public static RuleGroup buildRuleGroup(String creator,String groupName,String gitlab,List<Rule> rules){


        GroupIdentifier groupIdentifier = new GroupIdentifier(gitlab);

        GroupMetaData groupMetaData = new GroupMetaData(groupName, creator, Calendar.getInstance().getTime());

        RuleGroup ruleGroup = new RuleGroup(groupIdentifier, groupMetaData, rules);

        String ruleGroupId = UUID.randomUUID().toString();

        ruleGroup.setId(ruleGroupId);

        ruleGroup.setVersion(0);

        RuleGroupCreatedEvent event = new RuleGroupCreatedEvent(gitlab, ruleGroupId, rules);

        ruleGroup.setEvents(Arrays.asList(event));

        return ruleGroup;
    }
}
