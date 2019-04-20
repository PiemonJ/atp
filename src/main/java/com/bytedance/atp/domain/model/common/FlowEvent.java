package com.bytedance.atp.domain.model.common;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowEvent {

    //规则簇ID
    public String ruleGroupId;

    public String flowId;



}
