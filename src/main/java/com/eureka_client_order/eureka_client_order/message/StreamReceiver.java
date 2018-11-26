package com.eureka_client_order.eureka_client_order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/*
@Author Ming Zhou
@Date: 2018/11/25 21:58
*/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {
    @StreamListener(StreamClient.OUTPUT)
    @SendTo(StreamClient.INPUT)
    public String process(String msg){
        log.info("StreamReceiver:"+msg);
        return "successfully...";
    }

    @StreamListener(StreamClient.INPUT)
    public void processReturn(String msg){
        log.info("StreamReceiver From Return:"+msg);
    }
}
