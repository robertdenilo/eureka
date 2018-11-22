package com.eureka_client_order.eureka_client_order.service;

import com.eureka_client_order.eureka_client_order.dto.OrderDTO;
import org.springframework.stereotype.Service;

/*
@Author Ming Zhou
@Date: 2018/11/16 16:00
*/

public interface OrderService {

    public OrderDTO create(OrderDTO oDTO);
}
