package com.bytedance.atp.domain.model.group.event;

import com.bytedance.atp.common.Rule;
import com.bytedance.atp.domain.model.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleGroupChangedEvent extends DomainEvent {

    public String gitlab;

    public String ruleGroupId;

    public List<Rule> rules;
}
