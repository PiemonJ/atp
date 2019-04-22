package com.bytedance.atp;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.Direction;
import com.bytedance.atp.common.ExeStrategy;
import com.bytedance.atp.domain.model.group.RuleGroup;
import com.bytedance.atp.domain.model.group.RuleGroupRepository;
import com.bytedance.atp.resource.FlowResource;
import com.bytedance.atp.share.req.FlowProcessReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlowTester {
    @Autowired
    private FlowResource flowResource;
    @Autowired
    private RuleGroupRepository ruleGroupRepository;


    @Test
    public void test(){

        RuleGroup group = ruleGroupRepository.findByGroupIdentifierGitlab("www.guthub.com/piemon/atp");

        FlowProcessReq req = new FlowProcessReq();
        req.setCategory(Category.CODE);
        req.setDirection(Direction.TORUN);
        req.setExeStrategy(ExeStrategy.THROUGHOUT);

        req.setGitlab(group.getGroupIdentifier().getGitlab());

        flowResource.flow(req);

        try {
            Thread.sleep(100_00000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
