package com.eureka_client_order.eureka_client_order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/*
@Author Ming Zhou
@Date: 2018/11/25 21:55
*/
public interface StreamClient {
    String INPUT = "MyMessageIn";
    String OUTPUT =  "MyMessageOut";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
