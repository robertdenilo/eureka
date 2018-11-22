package com.eureka_client_order.eureka_client_order.repository;

import com.eureka_client_order.eureka_client_order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/*
@Author Ming Zhou
@Date: 2018/11/16 15:04
*/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
