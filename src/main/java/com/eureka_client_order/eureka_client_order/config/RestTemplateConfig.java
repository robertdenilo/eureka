package com.eureka_client_order.eureka_client_order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
@Author Ming Zhou
@Date: 2018/11/16 17:09
*/
//@Component  //use to replace new RestTemplate
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
