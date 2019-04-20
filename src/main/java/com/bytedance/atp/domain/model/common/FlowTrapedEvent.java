package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.common.Rule;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowTrapedEvent extends FlowEvent {

    public Rule rule;

    public FlowTrapedEvent() {
    }

    public FlowTrapedEvent(String ruleGroupId, String flowId, Rule rule) {
        super(ruleGroupId, flowId);
        this.rule = rule;
    }
}
