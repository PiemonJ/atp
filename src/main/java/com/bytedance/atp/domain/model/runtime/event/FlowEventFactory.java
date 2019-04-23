package com.bytedance.atp.domain.model.runtime.event;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.Rule;

public class FlowEventFactory {


    public static FlowStartedEvent withStarted(String groupId, String flowId, Category category){

        return new FlowStartedEvent(groupId,flowId,category);
    }


    public static FlowInterruptedEvent withInterrupted(String groupId, String flowId, Category category){

        return new FlowInterruptedEvent(groupId,flowId,category);
    }

    public static FlowMatchedEvent withMatched(String groupId, String flowId, Rule rule, Category category){

        return new FlowMatchedEvent(groupId,flowId,category,rule);
    }

    public static FlowNonMatchedEvent withNonMatched(String groupId, String flowId, Rule rule, Category category){

        return new FlowNonMatchedEvent(groupId,flowId,category,rule);

    }

    public static FlowTrapedEvent withTraped(String groupId, String flowId, Rule rule, Category category){

        return new FlowTrapedEvent(groupId,flowId,category,rule);
    }

    public static FlowTerminalEvent withTerminal(String groupId, String flowId, Category category){

        return new FlowTerminalEvent(groupId,flowId,category);
    }
}
