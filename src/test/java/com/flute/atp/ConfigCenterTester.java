package com.flute.atp;

import com.alibaba.fastjson.JSON;
import com.flute.atp.common.ConfigScalar;
import com.flute.atp.common.Single;
import com.flute.atp.common.Timer;
import com.flute.atp.common.Tuple2;
import com.flute.atp.domain.model.cc.ConfigCenter;
import com.flute.atp.domain.model.cc.Configer;
import com.flute.atp.domain.model.group.RuleGroup;
import com.flute.atp.domain.model.group.RuleGroupRepository;
import com.flute.atp.resource.ConfigCenterResource;
import com.flute.atp.share.req.BuildConfigCenterReq;
import com.flute.atp.share.req.CatConfigCenterReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigCenterTester {
    @Autowired
    private ConfigCenterResource configCenterResource;
    @Autowired
    private RuleGroupRepository ruleGroupRepository;

    @Test
    public void test(){

        RuleGroup ruleGroup = ruleGroupRepository.findByGroupIdentifierGitlab("www.guthub.com/piemon/atp");


        CatConfigCenterReq catConfigCenterReq = new CatConfigCenterReq();
        catConfigCenterReq.setGitlab("www.guthub.com/piemon/atp");
        catConfigCenterReq.setRuleGroupId(ruleGroup.getId());


        ConfigCenter configCenter = configCenterResource.catConfigCenter(catConfigCenterReq);


        List<Configer> activeConfiger = configCenter.obtainAllActiveConfiger();


        BuildConfigCenterReq buildConfigCenterReq = new BuildConfigCenterReq();



        Optional<Tuple2<ConfigScalar, String>> first = activeConfiger.stream()
                .map(configer -> Tuple2.apply(configer.getDescriptor().getScalar(),
                        JSON.toJSONString(Single.of(Tuple2.<Timer,Timer>apply(Timer.TUE_VALID,Timer.TUE_VALID)))))
                .findFirst();
        Tuple2<ConfigScalar, String> configScalarStringTuple2 = first.get();
        ConcurrentHashMap<ConfigScalar, String> map = new ConcurrentHashMap<>();
        map.put(configScalarStringTuple2._1,configScalarStringTuple2._2);

        buildConfigCenterReq.setRuleGroupId(ruleGroup.getId());
        buildConfigCenterReq.setConfiger(map);

        String s = JSON.toJSONString(buildConfigCenterReq);
        System.out.println(s);

        String s1 = configCenterResource.configCenterDefine(buildConfigCenterReq);

    }
}
