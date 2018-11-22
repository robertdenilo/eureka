package com.eureka_client_order.eureka_client_order.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/*
@Author Ming Zhou
@Date: 2018/11/19 15:46
*/
@Data
public class OrderDetailForm {
    @NotNull
    private String productId;
    @NotNull
    private String productQuantity;
    @JsonCreator
    public OrderDetailForm(@JsonProperty("productId") String productId, @JsonProperty("productQuantity") String productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
