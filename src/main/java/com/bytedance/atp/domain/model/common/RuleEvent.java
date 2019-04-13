package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.group.Rule;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleEvent {

    //规则簇ID
    public String ruleGroupId;

    public String flowId;

    public Rule rule;

}
