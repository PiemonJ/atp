package com.bytedance.atp.configuration;

import com.bytedance.atp.domain.model.runtime.event.FlowMeddleEvent;
import io.reactivex.processors.PublishProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowMeddleConfiguration {

    @Bean
    public PublishProcessor<FlowMeddleEvent> meddle(){

        return PublishProcessor.<FlowMeddleEvent>create();

    }




}
