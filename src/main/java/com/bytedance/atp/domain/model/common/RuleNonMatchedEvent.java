package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class RuleNonMatchedEvent extends RuleEvent{

    public RuleNonMatchedEvent() {
    }

    public RuleNonMatchedEvent(String ruleGroupId, String flowId, Rule rule) {
        super(ruleGroupId, flowId, rule);
    }
}
