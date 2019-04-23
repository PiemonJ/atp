package com.bytedance.atp.domain.model.runtime.event;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.Rule;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowMatchedEvent extends FlowEvent {

    public Rule rule;

    public FlowMatchedEvent(String ruleGroupId, String flowId, Category category, Rule rule) {
        super(ruleGroupId, flowId, category);
        this.rule = rule;
    }

    public FlowMatchedEvent(Rule rule) {
        this.rule = rule;
    }
}
