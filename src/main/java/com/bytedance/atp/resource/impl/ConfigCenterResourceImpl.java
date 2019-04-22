package com.bytedance.atp.resource.impl;

import com.bytedance.atp.application.ConfigCenterApplicationService;
import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.resource.ConfigCenterResource;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import com.bytedance.atp.share.req.CatConfigCenterReq;
import com.bytedance.atp.share.req.RebuildConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
