package com.bytedance.atp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableFeignClients
@SpringBootApplication
public class AtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtpApplication.class, args);
	}

}
