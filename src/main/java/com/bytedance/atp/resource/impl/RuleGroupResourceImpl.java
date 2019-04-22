package com.bytedance.atp.resource.impl;

import com.bytedance.atp.application.RuleGroupApplicationService;
import com.bytedance.atp.common.Tuple2;
import com.bytedance.atp.resource.RuleGroupResource;
import com.bytedance.atp.share.req.BuildRuleGroupReq;
import com.bytedance.atp.share.req.RebuildRuleGroupReq;
import com.bytedance.atp.share.resp.BuildRuleGroupResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleGroupResourceImpl implements RuleGroupResource {

    @Autowired
    private RuleGroupApplicationService ruleGroupApplicationService;


    public BuildRuleGroupResp buildRuleGroup(BuildRuleGroupReq req){

        Tuple2<String, Boolean> tuple2 = ruleGroupApplicationService.buildRuleGroup(req);


        return new BuildRuleGroupResp(tuple2._1,tuple2._2);

    }

}
