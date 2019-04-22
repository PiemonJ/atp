package com.bytedance.atp.resource;

import com.bytedance.atp.application.ConfigCenterApplicationService;
import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import com.bytedance.atp.share.req.CatConfigCenterReq;
import com.bytedance.atp.share.req.RebuildConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@FeignClient(name = "configCenterController",url = "http://localhost:8080/")
@RequestMapping("/config/center")
public interface ConfigCenterResource {

    @RequestMapping(method = RequestMethod.POST,
            value = "/define",
            consumes = "application/json",
            produces = "application/json"
    )
    public String configCenterDefine(BuildConfigCenterReq req);



    @RequestMapping(method = RequestMethod.GET,
            value = "/cat",
            consumes = "application/json",
            produces = "application/json"
    )
    public ConfigCenter catConfigCenter(CatConfigCenterReq req);
}
