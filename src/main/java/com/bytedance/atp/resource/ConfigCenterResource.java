package com.bytedance.atp.resource;

import com.bytedance.atp.application.ConfigCenterApplicationService;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import com.bytedance.atp.share.req.RebuildConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(url = "")
@RequestMapping("/config/center")
public interface ConfigCenterResource {

    @RequestMapping(method = RequestMethod.POST,
            value = "/build",
            consumes = "application/json",
            produces = "application/json"
    )
    public String buildConfigCenter(BuildConfigCenterReq req);

    @RequestMapping(method = RequestMethod.POST,
            value = "/rebuild",
            consumes = "application/json",
            produces = "application/json"
    )
    public String rebuildConfigCenter(RebuildConfigCenterReq req);
}
