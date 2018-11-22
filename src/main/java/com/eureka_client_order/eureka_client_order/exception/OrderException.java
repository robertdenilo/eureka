package com.eureka_client_order.eureka_client_order.exception;

import com.eureka_client_order.eureka_client_order.emun.ResultEnum;

/*
@Author Ming Zhou
@Date: 2018/11/19 14:48
*/
public class OrderException extends RuntimeException{
     private Integer code;
     public OrderException(Integer code,String errorMsg){
          super(errorMsg);
          this.code = code;
     }
     public OrderException(ResultEnum resultEnum){
          super(resultEnum.getMsg());
          this.code = resultEnum.getCode();
     }
}
