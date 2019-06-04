package com.flute.atp.application;

import com.flute.atp.common.Category;
import com.flute.atp.common.State;
import com.flute.atp.common.VerificationReport;
import com.flute.atp.domain.model.report.Reporting;
import com.flute.atp.domain.model.report.ReportingFactory;
import com.flute.atp.domain.model.report.ReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ReportingApplicationService {
    @Autowired
    private ReportingRepository reportingRepository;
    @Autowired
    public ApplicationEventPublisher bus;
    /**
     * 生成报告
     */
    public Boolean richReport(String ruleGroupId, String flowId, State state, VerificationReport vp){


        Reporting reporting = reportingRepository.findByRuleGroupIdAndFlowId(ruleGroupId, flowId);

        if (reporting == null){
            //消息速度不一致，导致事件消费无序
            //讲消息扔回队列
            return false;
        }

        reporting.rich(vp,state);
        reporting.events.stream().forEach(bus::publishEvent);
        reportingRepository.save(reporting);

        return true;

    }

    public void initReport(String ruleGroupId, String flowId, Category category){

        Reporting reporting = ReportingFactory.buildReporting(ruleGroupId, flowId, category);

        reportingRepository.save(reporting);

    }


    public void notifySat(String ruleGroupId, String flowId, Category category){

        Reporting reporting = reportingRepository.findByRuleGroupIdAndFlowId(ruleGroupId, flowId);

        if (reporting == null){
            //异常
        } else {
            //Http 调用sat 给他结果
            //TODO
        }

    }


    public Reporting catReportOfFlow(String ruleGroupId,String flowId){

        return reportingRepository.findByRuleGroupIdAndFlowId(ruleGroupId,flowId);

    }



}
