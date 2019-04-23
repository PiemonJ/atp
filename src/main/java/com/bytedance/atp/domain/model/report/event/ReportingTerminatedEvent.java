package com.bytedance.atp.domain.model.report.event;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.domain.model.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportingTerminatedEvent extends DomainEvent {

    public String ruleGroupId;

    public String flowId;

    public Category category;

}
