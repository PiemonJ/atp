package com.bytedance.atp.domain.model.runtime.event;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowInterruptedEvent extends FlowEvent {

    public FlowInterruptedEvent() {
    }

    public FlowInterruptedEvent(String ruleGroupId, String flowId) {
        super(ruleGroupId, flowId);
    }
}
