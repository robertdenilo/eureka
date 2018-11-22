package com.eureka_client_order.eureka_client_order.emun;

import lombok.Getter;

/*
@Author Ming Zhou
@Date: 2018/11/16 15:21
*/
@Getter
public enum OrderStatusEnum {
    NEW(0,"New Order"),FINISHED(1,"finished"),CANCEL(2,"cancelled");
    private Integer Code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        Code = code;
        this.msg = msg;
    }
}
