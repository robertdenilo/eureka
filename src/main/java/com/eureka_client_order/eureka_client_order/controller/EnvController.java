package com.eureka_client_order.eureka_client_order.controller;

import com.eureka_client_order.eureka_client_order.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@Author Ming Zhou
@Date: 2018/11/23 22:08
*/
@RestController
@RequestMapping("/env")
@RefreshScope    //use with config update in git then passed from rabbitmq with localhost/bus-refresh
public class EnvController {

    @Value("${env}")
    private String myEnv;
    @Autowired
    private PersonConfig person;

    @GetMapping("/print")
    public String getEnv(){
        return myEnv;
    }
    @GetMapping("/name")
    public String getName() {
        return person.getName();
    }
}
