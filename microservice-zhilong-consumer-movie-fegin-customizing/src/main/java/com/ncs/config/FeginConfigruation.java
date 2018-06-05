package com.ncs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeginConfigruation {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

}
