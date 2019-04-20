package com.bytedance.atp.resource;

import com.bytedance.atp.application.FlowApplicationService;
import com.bytedance.atp.share.req.FlowProcessReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(url = "")
@RequestMapping(value = "/flow")
public interface FlowResource {


    @RequestMapping(method = RequestMethod.POST,
            value = "/process",
            consumes = "application/json",
            produces = "application/json"
    )
    public String flow(FlowProcessReq req);
}
