package com.flute.atp.domain.model.report;

import com.flute.atp.common.Category;

import java.util.Calendar;
import java.util.UUID;

public class ReportingFactory {

    public static Reporting buildReporting(String ruleGroupId, String flowId, Category category){

        Reporting reporting = new Reporting();

        Clock clock = new Clock();
        clock.setFlowStart(Calendar.getInstance().getTime());


        reporting.setId(UUID.randomUUID().toString());
        reporting.setRuleGroupId(ruleGroupId);
        reporting.setFlowId(flowId);

        reporting.setCategory(category);

        reporting.setClock(clock);

        return reporting;
    }
}
