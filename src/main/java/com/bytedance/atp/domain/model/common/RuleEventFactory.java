package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.group.Rule;

public class RuleEventFactory {

    public RuleInterruptedEvent withInterrupt(String groupId, String flowId, Rule rule){

        return new RuleInterruptedEvent(groupId,flowId,rule);
    }

    public RuleMatchedEvent withMatched(String groupId,String flowId,Rule rule){

        return new RuleMatchedEvent(groupId,flowId,rule);
    }

    public RuleNonMatchedEvent withNonMatched(String groupId,String flowId,Rule rule){

        return new RuleNonMatchedEvent(groupId,flowId,rule);

    }

    public RuleTerminalEvent withTraped(String groupId,String flowId,Rule rule){

        return new RuleTerminalEvent(groupId,flowId,rule);
    }

    public RuleTrapedEvent withTerminal(String groupId,String flowId,Rule rule){

        return new RuleTrapedEvent(groupId,flowId,rule);
    }
}
