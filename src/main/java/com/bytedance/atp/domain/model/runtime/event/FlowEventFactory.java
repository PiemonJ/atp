package com.bytedance.atp.domain.model.runtime.event;

import com.bytedance.atp.common.Rule;

public class FlowEventFactory {


    public static FlowInterruptedEvent withInterrupt(String groupId, String flowId){

        return new FlowInterruptedEvent(groupId,flowId);
    }

    public static FlowMatchedEvent withMatched(String groupId, String flowId, Rule rule){

        return new FlowMatchedEvent(groupId,flowId,rule);
    }

    public static FlowNonMatchedEvent withNonMatched(String groupId, String flowId, Rule rule){

        return new FlowNonMatchedEvent(groupId,flowId,rule);

    }

    public static FlowTrapedEvent withTraped(String groupId, String flowId, Rule rule){

        return new FlowTrapedEvent(groupId,flowId,rule);
    }

    public static FlowTerminalEvent withTerminal(String groupId, String flowId){

        return new FlowTerminalEvent(groupId,flowId);
    }
}
