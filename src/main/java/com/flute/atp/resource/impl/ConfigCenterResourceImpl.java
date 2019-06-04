package com.flute.atp.resource.impl;

import com.flute.atp.application.ConfigCenterApplicationService;
import com.flute.atp.domain.model.cc.ConfigCenter;
import com.flute.atp.resource.ConfigCenterResource;
import com.flute.atp.share.req.BuildConfigCenterReq;
import com.flute.atp.share.req.CatConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigCenterResourceImpl implements ConfigCenterResource {

    @Autowired
    private ConfigCenterApplicationService configCenterApplicationService;


    @Override
    public String configCenterDefine(BuildConfigCenterReq req){

        configCenterApplicationService.configCenterDefiner(req.getRuleGroupId(),req.getConfiger());

        return "true";

    }


    @Override
    public ConfigCenter catConfigCenter(CatConfigCenterReq req) {


        return configCenterApplicationService.configCenterCater(req);

    }
}
