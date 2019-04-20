package com.bytedance.atp.application;

import com.bytedance.atp.core.compiler.Compiler;
import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.domain.model.cc.ConfigCenterRepository;
import com.bytedance.atp.domain.model.common.FlowMeddleEvent;
import com.bytedance.atp.domain.model.group.RuleGroup;
import com.bytedance.atp.domain.model.group.RuleGroupRepository;
import com.bytedance.atp.domain.model.runtime.Flow;
import com.bytedance.atp.common.Direction;
import com.bytedance.atp.common.Env;
import com.bytedance.atp.common.ExeStrategy;
import com.bytedance.atp.share.req.FlowProcessReq;
import io.reactivex.processors.PublishProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FlowApplicationService {

    @Resource
    private Compiler compiler;
    @Autowired
    RuleGroupRepository ruleGroupRepository;
    @Autowired
    ConfigCenterRepository configCenterRepository;
    //Hot Stream
    @Autowired
    public PublishProcessor<FlowMeddleEvent> meddle;


    public String flow(FlowProcessReq req) {

        Env env = req.getEnv();

        ExeStrategy exeStrategy = req.getExeStrategy();

        String ruleGroupId = req.getRuleGroupId();

        String flowId = req.getFlowId();

        Direction direction = req.getDirection();

        String flowID = "";

        switch (direction){

            case TORUN:

                RuleGroup ruleGroup = ruleGroupRepository.findOne(ruleGroupId);

                ConfigCenter configCenter = configCenterRepository.findByRuleGroupId(ruleGroupId);

                Flow flow = compiler.compile(env, exeStrategy, ruleGroup, configCenter);

                flowID = flow.getFlowId();

                flow.run();

                break;

            default:

                meddle.onNext(FlowMeddleEvent.apply(ruleGroupId,flowId,direction));

        }

        return flowID;


    }
}
