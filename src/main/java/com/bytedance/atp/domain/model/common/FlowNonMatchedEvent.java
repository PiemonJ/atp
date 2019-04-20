package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.common.Rule;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowNonMatchedEvent extends FlowEvent {

    public Rule rule;

    public FlowNonMatchedEvent() {
    }

    public FlowNonMatchedEvent(String ruleGroupId, String flowId, Rule rule) {
        super(ruleGroupId, flowId);
        this.rule = rule;
    }
}
