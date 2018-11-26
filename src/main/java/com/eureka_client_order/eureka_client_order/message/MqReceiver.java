package com.eureka_client_order.eureka_client_order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
@Author Ming Zhou
@Date: 2018/11/25 20:53
*/
@Slf4j
@Component
public class MqReceiver {
    //@RabbitListener(queues="myQueue1")
    //@RabbitListener(queuesToDeclare = @Queue("myQueue2"))
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myqueue3"),
            exchange = @Exchange("exchange1")
    ))
    public void process(String msg){
        log.info("mes is :"+msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myqueueType1"),
            key = "type1",
            exchange = @Exchange("order")
    ))
    public void processOrderType1(String msg){
        log.info("order typwe1 mes is :"+msg);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myqueueType2"),
            key = "type2",
            exchange = @Exchange("order")
    ))
    public void processOrderType2(String msg){
        log.info("order type2 mes is :"+msg);
    }
}
