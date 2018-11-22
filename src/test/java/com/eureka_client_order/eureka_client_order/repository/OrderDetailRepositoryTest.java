package com.eureka_client_order.eureka_client_order.repository;

import com.eureka_client_order.eureka_client_order.entity.OrderDetail;
import com.eureka_client_order.eureka_client_order.EurekaClientOrderApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*
@Author Ming Zhou
@Date: 2018/11/16 15:40
*/
@Component
public class OrderDetailRepositoryTest extends EurekaClientOrderApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail od = new OrderDetail();
        od.setDetailId("1234");
        od.setOrderId("1001");
        od.setProductId("1");
        od.setProductIcon("http://image.com");
        od.setProductName("辣条");
        od.setProductPrice(new BigDecimal(12));
        od.setProductQuantity(3);
        OrderDetail result = orderDetailRepository.save(od);
        Assert.assertTrue(result != null);
    }
}