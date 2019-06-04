package com.flute.atp.resource.impl;

import com.flute.atp.application.RuleGroupApplicationService;
import com.flute.atp.common.Tuple2;
import com.flute.atp.domain.model.group.RuleGroup;
import com.flute.atp.resource.RuleGroupResource;
import com.flute.atp.share.req.BuildRuleGroupReq;
import com.flute.atp.share.req.ObtainRuleGroupReq;
import com.flute.atp.share.resp.BuildRuleGroupResp;
import com.flute.atp.share.resp.ObtainRuleGroupResp;
import com.flute.atp.share.vo.RuleInfo;
import com.flute.atp.share.vo.ScalarInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class RuleGroupResourceImpl implements RuleGroupResource {

    @Autowired
    private RuleGroupApplicationService ruleGroupApplicationService;


    public BuildRuleGroupResp buildRuleGroup(BuildRuleGroupReq req){

        Tuple2<String, Boolean> tuple2 = ruleGroupApplicationService.buildRuleGroup(req);


        return new BuildRuleGroupResp(tuple2._1,tuple2._2);

    }


    @Override
    public ObtainRuleGroupResp obtainRuleGroup(ObtainRuleGroupReq obtainRuleGroupReq) {

        String gitlab = obtainRuleGroupReq.getGitlab();

        RuleGroup ruleGroup = ruleGroupApplicationService.obtainRuleGroup(gitlab);


        return ObtainRuleGroupResp.builder()
                .createTime(ruleGroup.getGroupMetaData().getCreateTime())
                .creator(ruleGroup.getGroupMetaData().getCreator())
                .gitlab(gitlab)
                .ruleGroupName(ruleGroup.getGroupMetaData().getRuleGroupName())
                .rules(
                        ruleGroup.rules.stream()
                        .map(rule ->
                            RuleInfo.builder()
                                    .category(rule.getCategory())
                                    .displayName(rule.name())
                                    .referenceScalars(
                                            rule.getConfigScalars().stream()
                                            .map(scalar ->
                                                ScalarInfo.builder()
                                                        .displayName(scalar.name())
                                                        .description(scalar.getDesc())
                                                        .build()
                                            ).collect(Collectors.toList())
                                    ).build()
                        ).collect(Collectors.toList())
                ).build();

    }

}
