package com.eureka_client_order.eureka_client_order.controller;

import com.eureka_client_order.eureka_client_order.message.StreamClient;
import com.eureka_client_order.eureka_client_order.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
@Author Ming Zhou
@Date: 2018/11/25 22:01
*/
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("sendMsg")
    public void processSend() {
        streamClient.output().send(MessageBuilder.withPayload("sendMsg now :" + new Date()).build());
    }
    @GetMapping("sendTransMsg")
    public void processTransform() {
        streamClient.output().send(MessageBuilder.withPayload("sendMsg now :" + new Date()).build());
    }
    @GetMapping("sendRmq")
    public void sendRabbitmq(){
        amqpTemplate.convertAndSend("myqueue3", "hello rabbit mq");
    }
}
