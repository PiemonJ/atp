package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.group.Rule;

public class RuleEventFactory {

    public static RuleInterruptedEvent withInterrupt(String groupId, String flowId){

        return new RuleInterruptedEvent(groupId,flowId);
    }

    public static RuleMatchedEvent withMatched(String groupId,String flowId,Rule rule){

        return new RuleMatchedEvent(groupId,flowId,rule);
    }

    public static RuleNonMatchedEvent withNonMatched(String groupId, String flowId,Rule rule){

        return new RuleNonMatchedEvent(groupId,flowId,rule);

    }

    public static RuleTrapedEvent withTraped(String groupId,String flowId,Rule rule){

        return new RuleTrapedEvent(groupId,flowId,rule);
    }

    public static RuleTerminalEvent withTerminal(String groupId,String flowId){

        return new RuleTerminalEvent(groupId,flowId);
    }
}
