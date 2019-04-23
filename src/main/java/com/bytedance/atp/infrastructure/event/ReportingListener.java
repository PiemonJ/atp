package com.bytedance.atp.infrastructure.event;

import com.bytedance.atp.application.ReportingApplicationService;
import com.bytedance.atp.common.Category;
import com.bytedance.atp.domain.model.report.event.ReportingTerminatedEvent;
import com.bytedance.atp.domain.model.runtime.event.FlowStartedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ReportingListener {


    //Spring上下文
    @Autowired
    public ApplicationEventPublisher bus;


    @Autowired
    private ReportingApplicationService reportingApplicationService;



    @Async
    @EventListener
    public void onTerminal(ReportingTerminatedEvent event) {
        //Invoke Report Rich Method
        String flowId = event.getFlowId();
        String ruleGroupId = event.getRuleGroupId();
        Category category = event.getCategory();

        reportingApplicationService.notifySat(ruleGroupId,flowId,category);


    }

}
