package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.common.Rule;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowMatchedEvent extends FlowEvent {

    public Rule rule;

    public FlowMatchedEvent() {
    }

    public FlowMatchedEvent(String ruleGroupId, String flowId, Rule rule) {
        super(ruleGroupId, flowId);
        this.rule = rule;
    }
}
