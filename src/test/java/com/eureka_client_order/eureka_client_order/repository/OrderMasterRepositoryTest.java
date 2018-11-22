package com.eureka_client_order.eureka_client_order.repository;

import com.eureka_client_order.eureka_client_order.emun.OrderStatusEnum;
import com.eureka_client_order.eureka_client_order.emun.PayStatusEnum;
import com.eureka_client_order.eureka_client_order.entity.OrderMaster;
import com.eureka_client_order.eureka_client_order.EurekaClientOrderApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*
@Author Ming Zhou
@Date: 2018/11/16 15:15
*/
@Component
public class OrderMasterRepositoryTest extends EurekaClientOrderApplicationTests {
   @Autowired
    private OrderMasterRepository orderMasterRepository;

   @Test
    public void testSave(){
       OrderMaster om = new OrderMaster();
       om.setOrderId("1001");
       om.setBuyerName("Ming");
       om.setBuyerPhone("514");
       om.setBuyerId("888");
       om.setOrderAmount(new BigDecimal(123.45));
       om.setBuyerAddr("montreal");
       om.setOrderStatus(OrderStatusEnum.NEW.getCode());
       om.setPayStatus(PayStatusEnum.WAIT.getCode());

       OrderMaster result = orderMasterRepository.save(om);
       Assert.assertTrue(result != null);
   }

}