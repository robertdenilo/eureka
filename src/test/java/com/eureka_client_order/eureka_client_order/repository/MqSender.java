package com.eureka_client_order.eureka_client_order.repository;

import com.eureka_client_order.eureka_client_order.EurekaClientOrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
@Author Ming Zhou
@Date: 2018/11/25 20:59
*/
@Component
public class MqSender extends EurekaClientOrderApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
         amqpTemplate.convertAndSend("myQueue1","now is" + new Date());
        amqpTemplate.convertAndSend("myQueue2","now is" + new Date());
        amqpTemplate.convertAndSend("myQueue3","now is" + new Date());
    }

    @Test
    public void sendType1(){
        amqpTemplate.convertAndSend("order","type1","1now is" + new Date());
    }
    @Test
    public void sendType2(){
        amqpTemplate.convertAndSend("order","type2","2now is" + new Date());
    }
}
