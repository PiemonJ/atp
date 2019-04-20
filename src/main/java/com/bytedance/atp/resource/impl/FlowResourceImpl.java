package com.bytedance.atp.resource.impl;

import com.bytedance.atp.application.FlowApplicationService;
import com.bytedance.atp.resource.FlowResource;
import com.bytedance.atp.share.req.FlowProcessReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowResourceImpl implements FlowResource {

    @Autowired
    private FlowApplicationService flowApplicationService;


    public String flow(FlowProcessReq req){

        return flowApplicationService.flow(req);

    }
}
