package com.flute.atp.domain.model.runtime.event;

import com.flute.atp.common.Category;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowEvent {

    //规则簇ID
    public String ruleGroupId;

    public String flowId;

    public Category category;

}
