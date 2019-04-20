package com.bytedance.atp.domain.model.report;

import java.util.Calendar;
import java.util.UUID;

public class ReportingFactory {

    public static Reporting buildReporting(String ruleGroupId,String flowId){

        Reporting reporting = new Reporting();

        Clock clock = new Clock();
        clock.setFlowStart(Calendar.getInstance().getTime());


        reporting.setId(UUID.randomUUID().toString());
        reporting.setRuleGroupId(ruleGroupId);
        reporting.setFlowId(flowId);

        reporting.setClock(clock);

        return reporting;
    }
}
