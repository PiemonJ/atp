package com.bytedance.atp.domain.model.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowTerminalEvent extends FlowEvent {

    public FlowTerminalEvent() {
    }

    public FlowTerminalEvent(String ruleGroupId, String flowId) {
        super(ruleGroupId, flowId);
    }
}
