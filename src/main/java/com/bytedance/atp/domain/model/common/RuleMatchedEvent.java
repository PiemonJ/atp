package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class RuleMatchedEvent extends RuleEvent {

    public Rule rule;

    public RuleMatchedEvent() {
    }

    public RuleMatchedEvent(String ruleGroupId, String flowId, Rule rule) {
        super(ruleGroupId, flowId);
        this.rule = rule;
    }
}
