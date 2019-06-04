package com.flute.atp.resource;

import com.flute.atp.share.req.FlowProcessReq;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "flowController",url = "http://localhost:8080/")
@RequestMapping(value = "/flow")
public interface FlowResource {


    /**
     * sat 发起HTTTP，触发Flow的执行
     *
     * @param req
     * @return
     */

    @RequestMapping(method = RequestMethod.POST,
            value = "/process",
            consumes = "application/json",
            produces = "application/json"
    )
    public String flow(FlowProcessReq req);
}
