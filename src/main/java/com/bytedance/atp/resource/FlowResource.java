package com.bytedance.atp.resource;

import com.bytedance.atp.application.FlowApplicationService;
import com.bytedance.atp.share.req.FlowProcessReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flow")
public class FlowResource {

    @Autowired
    private FlowApplicationService flowApplicationService;

    @PostMapping("/process")
    public void flow(FlowProcessReq req){

        flowApplicationService.flow(req);

    }
}
