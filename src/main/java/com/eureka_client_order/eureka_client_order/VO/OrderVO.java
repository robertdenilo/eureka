package com.eureka_client_order.eureka_client_order.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
@Author Ming Zhou
@Date: 2018/11/19 14:37
*/
@Data
public class OrderVO {
    @JsonProperty("orderId")
    private String orderId;
}
