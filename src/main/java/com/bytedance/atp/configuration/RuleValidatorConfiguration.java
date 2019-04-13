package com.bytedance.atp.configuration;

import com.bytedance.atp.core.validator.RuleValidator;
import com.bytedance.atp.domain.model.group.Rule;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ConcurrentHashMap;

public class RuleValidatorConfiguration {

    @Bean
    public ConcurrentHashMap<Rule, RuleValidator> ruleHandlerRegister(){

        return new ConcurrentHashMap<Rule, RuleValidator>();

    }



}
