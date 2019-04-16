package com.bytedance.atp.infrastructure.event;

import com.bytedance.atp.domain.model.common.*;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class FlowRuntimeListener {

    @Async
    @EventListener
    public void onnterrupted(RuleInterruptedEvent event) {
        //Invoke Report Rich Method

    }

    @Async
    @EventListener
    public void onTraped(RuleTrapedEvent event) {
        //Invoke Report Rich Method

    }

    @Async
    @EventListener
    public void onFMatched(RuleMatchedEvent event) {
        //Invoke Report Rich Method

    }


    @Async
    @EventListener
    public void onNonMatched(RuleNonMatchedEvent event) {
        //Invoke Report Rich Method

    }

    @Async
    @EventListener
    public void onTerminal(RuleTerminalEvent event) {
        //Invoke Report Rich Method

    }

}
