package com.eureka_client_order.eureka_client_order.repository;

import com.eureka_client_order.eureka_client_order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


/*
@Author Ming Zhou
@Date: 2018/11/16 15:13
*/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
