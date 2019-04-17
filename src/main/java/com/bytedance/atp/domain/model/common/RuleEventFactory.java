package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.group.Rule;

public class RuleEventFactory {

    public static RuleInterruptedEvent withInterrupt(long groupId, String flowId){

        return new RuleInterruptedEvent(groupId,flowId);
    }

    public static RuleMatchedEvent withMatched(long groupId,String flowId,Rule rule){

        return new RuleMatchedEvent(groupId,flowId,rule);
    }

    public static RuleNonMatchedEvent withNonMatched(long groupId, String flowId,Rule rule){

        return new RuleNonMatchedEvent(groupId,flowId,rule);

    }

    public static RuleTrapedEvent withTraped(long groupId,String flowId,Rule rule){

        return new RuleTrapedEvent(groupId,flowId,rule);
    }

    public static RuleTerminalEvent withTerminal(long groupId,String flowId){

        return new RuleTerminalEvent(groupId,flowId);
    }
}
