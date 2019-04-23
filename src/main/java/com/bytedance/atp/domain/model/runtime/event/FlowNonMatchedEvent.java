package com.bytedance.atp.domain.model.runtime.event;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.Rule;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowNonMatchedEvent extends FlowEvent {

    public Rule rule;

    public FlowNonMatchedEvent(String ruleGroupId, String flowId, Category category, Rule rule) {
        super(ruleGroupId, flowId, category);
        this.rule = rule;
    }

    public FlowNonMatchedEvent(Rule rule) {
        this.rule = rule;
    }
}
