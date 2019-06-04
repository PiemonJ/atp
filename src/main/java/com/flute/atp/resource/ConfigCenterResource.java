package com.flute.atp.resource;

import com.flute.atp.domain.model.cc.ConfigCenter;
import com.flute.atp.share.req.BuildConfigCenterReq;
import com.flute.atp.share.req.CatConfigCenterReq;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
