package com.flute.atp.domain.model.runtime.event;

import com.flute.atp.common.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowStartedEvent extends FlowEvent {


    public FlowStartedEvent(String ruleGroupId, String flowId, Category category) {
        super(ruleGroupId, flowId, category);
    }

    public FlowStartedEvent() {
    }
}
