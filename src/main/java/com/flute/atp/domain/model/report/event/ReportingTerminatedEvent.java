package com.flute.atp.domain.model.report.event;

import com.flute.atp.common.Category;
import com.flute.atp.domain.model.DomainEvent;
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
