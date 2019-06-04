package com.flute.atp;

import com.flute.atp.common.Rule;
import com.flute.atp.domain.model.cc.ConfigCenter;
import com.flute.atp.domain.model.cc.ConfigCenterRepository;
import com.flute.atp.domain.model.group.RuleGroup;
import com.flute.atp.domain.model.group.RuleGroupRepository;
import com.flute.atp.resource.RuleGroupResource;
import com.flute.atp.share.req.BuildRuleGroupReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleGroupChangedTester {

    @Autowired
    private RuleGroupResource ruleGroupResource;
    @Autowired
    private RuleGroupRepository ruleGroupRepository;
    @Autowired
    private ConfigCenterRepository configCenterRepository;

    @Test
    public void test(){

        BuildRuleGroupReq req = new BuildRuleGroupReq();
        req.setCreator("piemon");
        req.setGitlab("www.guthub.com/piemon/atp");
        req.setGroupName("atp工程");

        req.setRules(Arrays.asList(
                Rule.COVERAGE,
                Rule.WINDOW_PERIOD_RELEASE,
                Rule.BRANCH_NAME_STANDARD));

        ruleGroupResource.buildRuleGroup(req);
        try {
            Thread.sleep(50_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RuleGroup byGroupIdentifierGitlab = ruleGroupRepository.findByGroupIdentifierGitlab("www.guthub.com/piemon/atp");

        ConfigCenter byRuleGroupId = configCenterRepository.findByRuleGroupId(byGroupIdentifierGitlab.getId());

        System.out.println(byRuleGroupId);


        System.out.println(byGroupIdentifierGitlab);

    }
}
