package com.bytedance.atp.application;

import com.bytedance.atp.common.ConfigScalar;
import com.bytedance.atp.common.Env;
import com.bytedance.atp.common.Rule;
import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.domain.model.cc.ConfigCenterFactory;
import com.bytedance.atp.domain.model.cc.ConfigCenterRepository;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import com.bytedance.atp.share.req.CatConfigCenterReq;
import com.bytedance.atp.share.req.RebuildConfigCenterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConfigCenterApplicationService {

    @Autowired
    private ConfigCenterRepository configCenterRepository;


    /**、
     * 配置中心的初始化
     * PS:当规则组创建后，会发送RuleGroupCreatedEvent,接收该消息，并初始化配置中心
     * @param ruleGroupId
     * @param rules
     */
    public void configCenterIniter(String gitlab,String ruleGroupId,List<Rule> rules){

        ConfigCenter cc = configCenterRepository.findByRuleGroupId(ruleGroupId);

        if (cc == null){

            ConfigCenter configCenter = ConfigCenterFactory.configCenterIniter(gitlab,ruleGroupId, rules);

            configCenterRepository.save(configCenter);
        }
    }


    /**
     * 配置中心变更
     * PS:当规则组被修改后，就会发送RuleGroupChangedEvent，接收消息，并对配置中心做变更处理
     * @param ruleGroupId
     * @param rules
     */
    public void configCenterChanger(String gitlab,String ruleGroupId,List<Rule> rules){

        ConfigCenter cc = configCenterRepository.findByRuleGroupId(ruleGroupId);

        if (cc != null){

            ConfigCenter configCenter = ConfigCenterFactory.configCenterChanger(gitlab,cc, rules);

            configCenterRepository.save(configCenter);
        }
    }


    /**
     * 配置中心自定义
     * PS:纯接口调用，用户修改默认值
     * @param ruleGroupId
     * @param defined
     */
    public void configCenterDefiner(String ruleGroupId, Map<ConfigScalar,String> defined){

        ConfigCenter cc = configCenterRepository.findByRuleGroupId(ruleGroupId);

        if (cc == null){

           //异常，抛异常

        } else {

            cc.configApply(defined);

            configCenterRepository.save(cc);
        }
    }



    public ConfigCenter configCenterCater(CatConfigCenterReq req){

        String gitlab = req.getGitlab();

        String ruleGroupId = req.getRuleGroupId();

        ConfigCenter cc = configCenterRepository.findByRuleGroupId(ruleGroupId);

        return cc;

    }
}
