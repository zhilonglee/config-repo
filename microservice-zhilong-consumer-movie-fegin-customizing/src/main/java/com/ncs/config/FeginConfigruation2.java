package com.ncs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeginConfigruation2 {
	
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "admin");
    }
    
    @Bean
    public Logger.Level feignLoggerLevel(){
    	return Logger.Level.FULL; 
    }
}
