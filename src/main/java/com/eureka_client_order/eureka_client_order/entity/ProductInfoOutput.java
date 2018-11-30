package com.eureka_client_order.eureka_client_order.entity;

import lombok.Data;

import java.math.BigDecimal;

/*
@Author Ming Zhou
@Date: 2018/11/30 12:20
*/
@Data
public class ProductInfoOutput {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStatus;
    private Integer productStock;
}

