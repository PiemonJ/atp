package com.flute.atp.domain.model.runtime.event;

import com.flute.atp.common.Category;
import lombok.*;

@Data
public class FlowInterruptedEvent extends FlowEvent {
    public FlowInterruptedEvent(String ruleGroupId, String flowId, Category category) {
        super(ruleGroupId, flowId, category);
    }

    public FlowInterruptedEvent() {
    }

}
