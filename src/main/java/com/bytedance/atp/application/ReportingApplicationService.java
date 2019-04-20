package com.bytedance.atp.application;

import com.bytedance.atp.common.Rule;
import com.bytedance.atp.common.State;
import com.bytedance.atp.domain.model.report.Reporting;
import com.bytedance.atp.domain.model.report.ReportingFactory;
import com.bytedance.atp.domain.model.report.ReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingApplicationService {
    @Autowired
    private ReportingRepository reportingRepository;

    /**
     * 生成报告
     */
    public Boolean richReport(String ruleGroupId, String flowId, State state, Rule rule,Boolean whetherMatched){


        Reporting reporting = reportingRepository.findByRuleGroupIdAndFlowId(ruleGroupId, flowId);

        if (reporting == null){
            //消息速度不一致，导致事件消费无序
            //讲消息扔回队列
            return false;
        }

        reporting.rich(rule,state,whetherMatched);
        reportingRepository.save(reporting);

        return true;

    }

    public void initReport(String ruleGroupId,String flowId){

        Reporting reporting = ReportingFactory.buildReporting(ruleGroupId, flowId);

        reportingRepository.save(reporting);

    }

    public Reporting catReportOfFlow(String ruleGroupId,String flowId){

        return reportingRepository.findByRuleGroupIdAndFlowId(ruleGroupId,flowId);

    }

    public List<Reporting> catReportOfRuleGroup(String ruleGroupId){

        return reportingRepository.findAllByRuleGroupId(ruleGroupId);

    }


}
