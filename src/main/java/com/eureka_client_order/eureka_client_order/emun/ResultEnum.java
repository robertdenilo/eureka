package com.eureka_client_order.eureka_client_order.emun;

import lombok.Getter;

/*
@Author Ming Zhou
@Date: 2018/11/19 22:17
*/
@Getter
public enum ResultEnum {
    PARAM_ERROR(0,"param errps"),CART_EMPTY(2,"cart empty");
    private Integer code;
    private String msg;
    ResultEnum(Integer code, String msg){
         this.code = code;
         this.msg = msg;
    }
}
