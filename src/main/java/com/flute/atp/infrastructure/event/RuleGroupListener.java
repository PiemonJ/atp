package com.flute.atp.infrastructure.event;

import com.flute.atp.application.ConfigCenterApplicationService;
import com.flute.atp.common.Rule;
import com.flute.atp.domain.model.group.event.RuleGroupChangedEvent;
import com.flute.atp.domain.model.group.event.RuleGroupCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleGroupListener {


    //Spring上下文
    public ApplicationEventPublisher bus;


    @Autowired
    private ConfigCenterApplicationService configCenterApplicationService;

    @Async
    @EventListener
    public void onRuleGroupCreated(RuleGroupCreatedEvent event) {
        //Invoke Report Rich Method
        String gitlab = event.getGitlab();
        List<Rule> rules = event.getRules();
        String ruleGroupId = event.getRuleGroupId();

        configCenterApplicationService.configCenterIniter(gitlab,ruleGroupId,rules);

    }


    @Async
    @EventListener
    public void onRuleGroupChanged(RuleGroupChangedEvent event) {
        //Invoke Report Rich Method
        String gitlab = event.getGitlab();
        List<Rule> rules = event.getRules();
        String ruleGroupId = event.getRuleGroupId();

        configCenterApplicationService.configCenterChanger(gitlab,ruleGroupId,rules);

    }
}
