package com.bytedance.atp.application;

import com.bytedance.atp.common.Tuple2;
import com.bytedance.atp.domain.model.group.RuleGroup;
import com.bytedance.atp.domain.model.group.RuleGroupFactory;
import com.bytedance.atp.domain.model.group.RuleGroupRepository;
import com.bytedance.atp.share.req.BuildRuleGroupReq;
import com.bytedance.atp.share.req.RebuildRuleGroupReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

@Service
public class RuleGroupApplicationService {

    @Autowired
    public ApplicationEventPublisher bus;

    @Autowired
    private RuleGroupRepository ruleGroupRepository;


    public Tuple2<String,Boolean> buildRuleGroup(BuildRuleGroupReq req){

        String creator = req.getCreator();
        String groupName = req.getGroupName();
        String gitlab = req.getGitlab();

        RuleGroup group = ruleGroupRepository.findByGroupIdentifierGitlab(gitlab);

        if (group == null){
            //满足幂等
            RuleGroup ruleGroup = RuleGroupFactory.buildRuleGroup(creator, groupName, gitlab, req.getRules());

            ruleGroup = ruleGroupRepository.save(ruleGroup);

            ruleGroup.getEvents().stream().forEach(bus::publishEvent);


            return Tuple2.apply(String.valueOf(ruleGroup.getId()),true);

        } else {

            group.rebuild(req.getRules());

            ruleGroupRepository.save(group);

            return Tuple2.apply(group.getId(),true);
        }


    }

}
