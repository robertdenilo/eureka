package com.eureka_client_order.eureka_client_order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/*
@Author Ming Zhou
@Date: 2018/11/23 22:19
*/
@Component
@Data
@ConfigurationProperties("person")
@RefreshScope
public class PersonConfig {
    private String name;
    private Integer age;
}
