package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class RuleTerminalEvent extends RuleEvent {

    public RuleTerminalEvent() {
    }

    public RuleTerminalEvent(long ruleGroupId, String flowId) {
        super(ruleGroupId, flowId);
    }
}
