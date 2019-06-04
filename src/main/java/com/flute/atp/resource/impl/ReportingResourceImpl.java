package com.flute.atp.resource.impl;

import com.flute.atp.application.ReportingApplicationService;
import com.flute.atp.domain.model.report.Reporting;
import com.flute.atp.resource.ReportingResource;
import com.flute.atp.share.req.CatReportReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingResourceImpl implements ReportingResource {

    @Autowired
    private ReportingApplicationService reportingApplicationService;


    @Override
    public Reporting catReportOfFlow(CatReportReq req) {
        String ruleGroupId = req.getRuleGroupId();
        String flowId = req.getFlowId();
        return reportingApplicationService.catReportOfFlow(ruleGroupId,flowId);
    }
}
