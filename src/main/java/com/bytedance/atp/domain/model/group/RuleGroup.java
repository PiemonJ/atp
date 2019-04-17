package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.AggregateRoot;
import sun.rmi.log.LogInputStream;

import java.util.List;

public class RuleGroup extends AggregateRoot {

    GroupIdentifier groupIdentifier;

    public List<Rule> rules;



    public RuleGroup(GroupIdentifier groupIdentifier, List<Rule> rules) {
        this.groupIdentifier = groupIdentifier;
        this.rules = rules;
    }



}
