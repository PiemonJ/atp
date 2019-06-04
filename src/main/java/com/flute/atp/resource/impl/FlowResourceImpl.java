package com.flute.atp.resource.impl;

import com.flute.atp.application.FlowApplicationService;
import com.flute.atp.resource.FlowResource;
import com.flute.atp.share.req.FlowProcessReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowResourceImpl implements FlowResource {

    @Autowired
    private FlowApplicationService flowApplicationService;


    public String flow(FlowProcessReq req){

        return flowApplicationService.flow(req);

    }
}
