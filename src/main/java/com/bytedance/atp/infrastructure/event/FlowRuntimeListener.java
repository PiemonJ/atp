package com.bytedance.atp.infrastructure.event;

import com.bytedance.atp.application.ReportingApplicationService;
import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.Rule;
import com.bytedance.atp.common.State;
import com.bytedance.atp.domain.model.runtime.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class FlowRuntimeListener {


    //Spring上下文
    @Autowired
    public ApplicationEventPublisher bus;


    @Autowired
    private ReportingApplicationService reportingApplicationService;

    @Async
    @EventListener
    public void onStarted(FlowStartedEvent event) {
        //Invoke Report Rich Method
        String flowId = event.getFlowId();
        String ruleGroupId = event.getRuleGroupId();
        Category category = event.getCategory();

        reportingApplicationService.initReport(ruleGroupId,flowId,category);


    }


    @Async
    @EventListener
    public void onnterrupted(FlowInterruptedEvent event) {
        //Invoke Report Rich Method
        String flowId = event.getFlowId();
        String ruleGroupId = event.getRuleGroupId();

        Boolean ok = reportingApplicationService.richReport(ruleGroupId, flowId, State.INTERRUPT, null,null);

        if (!ok)
            bus.publishEvent(event);


    }

    @Async
    @EventListener
    public void onTraped(FlowTrapedEvent event) {
        //Invoke Report Rich Method
        //Invoke Report Rich Method
        String flowId = event.getFlowId();
        String ruleGroupId = event.getRuleGroupId();

        Rule rule = event.getRule();

        Boolean ok = reportingApplicationService.richReport(ruleGroupId, flowId, State.TRAP, rule,null);

        if (!ok)
            bus.publishEvent(event);
    }

    @Async
    @EventListener
    public void onFMatched(FlowMatchedEvent event) {
        //Invoke Report Rich Method
        //Invoke Report Rich Method
        //Invoke Report Rich Method
        String flowId = event.getFlowId();
        String ruleGroupId = event.getRuleGroupId();

        Rule rule = event.getRule();

        Boolean ok = reportingApplicationService.richReport(ruleGroupId, flowId, State.RUNNING, rule,true);

        if (!ok)
            bus.publishEvent(event);
    }


    @Async
    @EventListener
    public void onNonMatched(FlowNonMatchedEvent event) {
        //Invoke Report Rich Method
        String flowId = event.getFlowId();
        String ruleGroupId = event.getRuleGroupId();

        Rule rule = event.getRule();

        Boolean ok = reportingApplicationService.richReport(ruleGroupId, flowId, State.RUNNING, rule,false);

        if (!ok)
            bus.publishEvent(event);
    }

    @Async
    @EventListener
    public void onTerminal(FlowTerminalEvent event) {
        //Invoke Report Rich Method
        String flowId = event.getFlowId();
        String ruleGroupId = event.getRuleGroupId();

        Boolean ok = reportingApplicationService.richReport(ruleGroupId, flowId, State.DONE, null,false);

        if (!ok)
            bus.publishEvent(event);

    }

}
