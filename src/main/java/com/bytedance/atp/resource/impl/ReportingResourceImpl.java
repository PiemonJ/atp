package com.bytedance.atp.resource.impl;

import com.bytedance.atp.application.ReportingApplicationService;
import com.bytedance.atp.domain.model.report.Reporting;
import com.bytedance.atp.resource.ReportingResource;
import com.bytedance.atp.share.req.CatReportReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportingResourceImpl implements ReportingResource {

    @Autowired
    private ReportingApplicationService reportingApplicationService;

//    @Override
//    public List<Reporting> catReportOfRuleGroup(CatReportReq req) {
//
//        String ruleGroupId = req.getRuleGroupId();
//        return reportingApplicationService.catReportOfRuleGroup(ruleGroupId);
//
//    }
//
//    @Override
//    public Reporting catReportOfFlow(CatReportReq req) {
//        String ruleGroupId = req.getRuleGroupId();
//        String flowId = req.getFlowId();
//        return reportingApplicationService.catReportOfFlow(ruleGroupId,flowId);
//    }
}
