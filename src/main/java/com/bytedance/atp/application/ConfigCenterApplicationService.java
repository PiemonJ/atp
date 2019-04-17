package com.bytedance.atp.application;

import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.domain.model.cc.ConfigCenterFactory;
import com.bytedance.atp.domain.model.cc.ConfigCenterRepository;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigCenterApplicationService {

    @Autowired
    private ConfigCenterRepository configCenterRepository;

    public void buildConfigCenter(BuildConfigCenterReq req){

        ConfigCenter cc = configCenterRepository.findByRuleGroupId(req.getRuleGroupId());

        if (cc == null){

            ConfigCenter configCenter = ConfigCenterFactory.buildConfigCenter(req.getEnv(), req.getRuleGroupId(), req.getConfiger());

            configCenterRepository.save(configCenter);
        } else {

            cc.configApply(req.getEnv(),req.getConfiger());

            configCenterRepository.save(cc);

        }
    }
}
