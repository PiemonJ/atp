package com.bytedance.atp;

import com.bytedance.atp.core.compiler.Compiler;
import com.bytedance.atp.domain.model.cc.ConfigCenter;
import com.bytedance.atp.domain.model.cc.ReleaseInfo;
import com.bytedance.atp.domain.model.common.Weekday;
import com.bytedance.atp.domain.model.group.GroupIdentifier;
import com.bytedance.atp.domain.model.group.Rule;
import com.bytedance.atp.domain.model.group.RuleGroup;
import com.bytedance.atp.domain.model.runtime.ExeStrategy;
import com.bytedance.atp.domain.model.runtime.Flow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.ConcurrentNavigableMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtpApplicationTests {
	@Resource
	private Compiler compiler;

	@Test
	public void contextLoads() {
		//创建规则组
		GroupIdentifier groupIdentifier = new GroupIdentifier("TestGroup", "Tester");
		RuleGroup ruleGroup = new RuleGroup(groupIdentifier, Arrays.asList(Rule.WINDOW_PERIOD_RELEASE));
		ruleGroup.setId(1L);
		ruleGroup.setVersion(0);

		//配置ConfigCenter
		ConfigCenter configCenter = new ConfigCenter();
		configCenter.setId(2L);
		configCenter.setVersion(0);

		ReleaseInfo releaseInfo = new ReleaseInfo();
		releaseInfo.setValidReleaseDay(Arrays.asList(Weekday.TUE,Weekday.THU));
		configCenter.setReleaseInfo(releaseInfo);

		//执行规则组
		Flow flow = compiler.compile(ExeStrategy.FAIL_FAST, ruleGroup, configCenter);

		flow.run();
	}

}
