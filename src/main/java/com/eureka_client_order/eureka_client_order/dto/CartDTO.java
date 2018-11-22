package com.eureka_client_order.eureka_client_order.dto;

import lombok.Data;

/*
@Author Ming Zhou
@Date: 2018/11/17 7:26
*/
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(){}  //serialize ???

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
