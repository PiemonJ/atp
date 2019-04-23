package com.bytedance.atp.domain.model.runtime.event;

import com.bytedance.atp.common.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowTerminalEvent extends FlowEvent {
    public FlowTerminalEvent(String ruleGroupId, String flowId, Category category) {
        super(ruleGroupId, flowId, category);
    }

    public FlowTerminalEvent() {
    }
}
