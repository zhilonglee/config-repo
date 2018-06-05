package com.ncs.zhilong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CustomingPropertiesSourceLocatorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomingPropertiesSourceLocatorDemoApplication.class);
	}
}
