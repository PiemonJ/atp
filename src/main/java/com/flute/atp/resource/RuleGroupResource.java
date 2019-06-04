package com.flute.atp.resource;

import com.flute.atp.share.req.BuildRuleGroupReq;
import com.flute.atp.share.req.ObtainRuleGroupReq;
import com.flute.atp.share.resp.BuildRuleGroupResp;
import com.flute.atp.share.resp.ObtainRuleGroupResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "ruleGroupController",url = "http://localhost:8080/")
@RequestMapping("/rule/group")
public interface RuleGroupResource {


    @RequestMapping(method = RequestMethod.POST,
            value = "/build",
            consumes = "application/json",
            produces = "application/json"
    )
    public BuildRuleGroupResp buildRuleGroup(BuildRuleGroupReq req);

//    @RequestMapping(method = RequestMethod.POST,
//            value = "/rebuild",
//            consumes = "application/json",
//            produces = "application/json"
//    )
//    public Boolean rebuildRuleGroup(RebuildRuleGroupReq req);

    public ObtainRuleGroupResp obtainRuleGroup(ObtainRuleGroupReq obtainRuleGroupReq);

}
