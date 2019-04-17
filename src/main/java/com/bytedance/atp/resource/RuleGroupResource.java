package com.bytedance.atp.resource;

import com.bytedance.atp.application.RuleGroupApplicationService;
import com.bytedance.atp.share.req.BuildRuleGroupReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rule/group")
public class RuleGroupResource {
    @Autowired
    private RuleGroupApplicationService ruleGroupApplicationService;

    @PostMapping("/build")
    public String  buildRuleGroup(BuildRuleGroupReq req){

        ruleGroupApplicationService.buildRuleGroup(req);

        return "true";

    }


}
