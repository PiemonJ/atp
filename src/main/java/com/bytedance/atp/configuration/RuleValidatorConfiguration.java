package com.bytedance.atp.configuration;

import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.common.Rule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;
@Configuration
public class RuleValidatorConfiguration {

    @Bean(name = "ruleHandlerRegister")
    public ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister(){

        return new ConcurrentHashMap<Rule, RuleValidator>();

    }



}
