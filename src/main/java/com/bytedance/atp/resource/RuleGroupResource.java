package com.bytedance.atp.resource;

import com.bytedance.atp.application.RuleGroupApplicationService;
import com.bytedance.atp.share.req.BuildRuleGroupReq;
import com.bytedance.atp.share.req.RebuildRuleGroupReq;
import com.bytedance.atp.share.resp.BuildRuleGroupResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(url = "")
@RequestMapping("/rule/group")
public interface RuleGroupResource {


    @RequestMapping(method = RequestMethod.POST,
            value = "/build",
            consumes = "application/json",
            produces = "application/json"
    )
    public BuildRuleGroupResp buildRuleGroup(BuildRuleGroupReq req);

    @RequestMapping(method = RequestMethod.POST,
            value = "/rebuild",
            consumes = "application/json",
            produces = "application/json"
    )
    public Boolean rebuildRuleGroup(RebuildRuleGroupReq req);

}
