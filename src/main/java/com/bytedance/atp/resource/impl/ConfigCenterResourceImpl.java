package com.bytedance.atp.resource.impl;

import com.bytedance.atp.application.ConfigCenterApplicationService;
import com.bytedance.atp.resource.ConfigCenterResource;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import com.bytedance.atp.share.req.RebuildConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigCenterResourceImpl implements ConfigCenterResource {

    @Autowired
    private ConfigCenterApplicationService configCenterApplicationService;



    public String buildConfigCenter(BuildConfigCenterReq req){

        configCenterApplicationService.buildConfigCenter(req);

        return "true";

    }


    public String rebuildConfigCenter(RebuildConfigCenterReq req){

        configCenterApplicationService.rebuildConfigCenter(req);

        return "true";
    }
}
