package com.flute.atp.configuration;

import com.flute.atp.core.validator.RuleValidator;
import com.flute.atp.common.Rule;
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
