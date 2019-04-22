package com.bytedance.atp.domain.model.runtime.event;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowStartedEvent extends FlowEvent {

    public FlowStartedEvent() {
    }

    public FlowStartedEvent(String ruleGroupId, String flowId) {
        super(ruleGroupId, flowId);
    }
}
