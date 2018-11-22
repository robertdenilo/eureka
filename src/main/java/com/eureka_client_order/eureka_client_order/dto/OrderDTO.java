package com.eureka_client_order.eureka_client_order.dto;

import com.eureka_client_order.eureka_client_order.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/*
@Author Ming Zhou
@Date: 2018/11/16 16:03
*/
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddr;
    private String buyerId;
    private BigDecimal buyerAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private List<OrderDetail> orderDetailList;
}
