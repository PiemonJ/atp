package com.bytedance.atp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bytedance.atp.common.ConfigScalar;
import com.bytedance.atp.common.Env;
import com.bytedance.atp.common.Rule;
import com.bytedance.atp.common.Template;
import com.bytedance.atp.common.Weekday;
import com.bytedance.atp.resource.ConfigCenterResource;
import com.bytedance.atp.resource.RuleGroupResource;
import com.bytedance.atp.share.req.BuildConfigCenterReq;
import com.bytedance.atp.share.req.BuildRuleGroupReq;
import com.bytedance.atp.share.resp.BuildRuleGroupResp;
import feign.Feign;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        RuleGroupResource ruleGroupResource = Feign.builder()
                .contract(new SpringMvcContract())
                .target(RuleGroupResource.class, "http://127.0.0.1:9999");


        ConfigCenterResource configCenterResource = Feign.builder()
                .contract(new SpringMvcContract())
                .target(ConfigCenterResource.class, "http://127.0.0.1:9999");

        Template.Builder builder = Template.builder();
        builder.applyRuleOfConverage()
                .richCoverage(BigDecimal.ONE);
        builder.applyRuleOfWindowPeriodRelease()
                .richDateInterval(null,null);
        Template template = builder.build();

        List<Rule> rules = template.getRules();

        Map<ConfigScalar, String> configers = template.getConfigers();

        BuildRuleGroupResp buildRuleGroupResp = ruleGroupResource.buildRuleGroup(new BuildRuleGroupReq("creator", "name", ".git",rules));

        String ruleGroupId = buildRuleGroupResp.getRuleGroupId();

        String ok = configCenterResource.configCenterDefine(new BuildConfigCenterReq(Env.TEST, ruleGroupId, configers));



        String s = JSON.toJSONString(Arrays.asList(Weekday.FRI));
        System.out.println(s);

        Object o = JSON.parseObject("[\"TRU\"]", new TypeReference<List<Weekday>>() {
        }.getType());

        Object o1 = JSON.parseObject(s, new TypeReference<List<Weekday>>() {
        }.getType());






    }
}
