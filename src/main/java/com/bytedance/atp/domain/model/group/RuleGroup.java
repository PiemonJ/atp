package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.AggregateRoot;
import sun.rmi.log.LogInputStream;

import java.util.List;

public class RuleGroup extends AggregateRoot {

    GroupIdentifier identifier;

    public List<Rule> rules;



    public RuleGroup(GroupIdentifier identifier, List<Rule> rules) {
        this.identifier = identifier;
        this.rules = rules;
    }


}
