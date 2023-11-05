package org.utech.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    @LoadBalanced //after enabling eureka config restTemplate will confuse which port to send request the hence we need LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
