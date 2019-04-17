package com.bytedance.atp.resource;

import com.bytedance.atp.application.ConfigCenterApplicationService;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import com.bytedance.atp.share.req.RebuildConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/config/center")
public class ConfigCenterResource {

    @Autowired
    private ConfigCenterApplicationService configCenterApplicationService;


    @PostMapping("/build")
    public String buildConfigCenter(BuildConfigCenterReq req){

        configCenterApplicationService.buildConfigCenter(req);

        return "true";

    }

    @PostMapping("/rebuild")
    public String rebuildConfigCenter(RebuildConfigCenterReq req){

        configCenterApplicationService.rebuildConfigCenter(req);

        return "true";
    }
}
