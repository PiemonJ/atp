package com.bytedance.atp.application;

import com.bytedance.atp.common.Tuple2;
import com.bytedance.atp.domain.model.group.RuleGroup;
import com.bytedance.atp.domain.model.group.RuleGroupFactory;
import com.bytedance.atp.domain.model.group.RuleGroupRepository;
import com.bytedance.atp.share.req.BuildRuleGroupReq;
import com.bytedance.atp.share.req.RebuildRuleGroupReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleGroupApplicationService {
    @Autowired
    private RuleGroupRepository ruleGroupRepository;


    public Tuple2<String,Boolean> buildRuleGroup(BuildRuleGroupReq req){

        String creator = req.getCreator();
        String groupName = req.getGroupName();

        RuleGroup group = ruleGroupRepository.findByGroupIdentifierCreatorAndGroupIdentifierGroupName(creator, groupName);

        if (group == null){
            //满足幂等
            RuleGroup ruleGroup = RuleGroupFactory.buildRuleGroup(creator, groupName, req.getRules());

            ruleGroup = ruleGroupRepository.save(ruleGroup);

            return Tuple2.apply(String.valueOf(ruleGroup.getId()),true);
        }
        return Tuple2.apply("",false);

    }

    public Tuple2<String,Boolean> rebuildRuleGroup(RebuildRuleGroupReq req) {

        String groupName = req.getGroupName();

        RuleGroup group = ruleGroupRepository.findOne(req.getRuleGroupId());

        if (group != null){
            //满足幂等



            group.rebuild(groupName,req.getRules());

            ruleGroupRepository.save(group);


            return Tuple2.apply(String.valueOf(""),true);
        }
        return Tuple2.apply("",false);

    }
}
