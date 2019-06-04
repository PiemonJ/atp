package com.flute.atp;

import com.flute.atp.core.compiler.Compiler;
import com.bytedance.atp.domain.model.cc.*;
import com.flute.atp.domain.model.group.RuleGroup;
import com.flute.atp.domain.model.group.RuleGroupRepository;
import com.flute.atp.domain.model.cc.ConfigCenterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtpApplicationTests {
	@Resource
	private Compiler compiler;
	@Autowired
    ConfigCenterRepository configCenterRepository;
	@Autowired
	RuleGroupRepository ruleGroupRepository;

	@Test
	public void contextLoads() {
		//创建规则组
//		GroupIdentifier groupIdentifier = new GroupIdentifier("TestGroup", "Tester");
//		RuleGroup ruleGroup = new RuleGroup(groupIdentifier, Arrays.asList(Rule.WINDOW_PERIOD_RELEASE));
//		ruleGroup.setId(0L);
//		ruleGroup.setVersion(0);
//		ruleGroupRepository.save(ruleGroup);

		RuleGroup rg = ruleGroupRepository.findByGroupIdentifierGitlab("Tester");

		System.out.println(rg);




//		//配置ConfigCenter
//		ConfigCenter configCenter = new ConfigCenter();
//		configCenter.setId(0L);
//		configCenter.setVersion(0);
//		configCenter.setRuleGroupId(String.valueOf(ruleGroup.getId()));
//
//		configCenter.configApply(
//				Env.TEST,
//				Arrays.asList(Configer.apply(ConfigDescriptor.RELEASE_VALID_DAY,new ConfigValue("[\"FRI\"]")))
//		);
//
//		ConfigCenter save = configCenterRepository.save(configCenter);
//
//		ConfigCenter byGroupId = configCenterRepository.findByRuleGroupId("0");
//
//		ConfigCenter one = configCenterRepository.findOne(0L);
//
//		List<ConfigCenter> all = configCenterRepository.findAll();
//
//		//执行规则组
//		Flow flow = compiler.compile(Env.TEST,ExeStrategy.FAIL_FAST, ruleGroup, configCenter);
//
//		System.out.println(flow);
//
//		flow.run();
	}

}
