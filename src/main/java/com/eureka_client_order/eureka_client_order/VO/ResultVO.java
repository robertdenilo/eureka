package com.eureka_client_order.eureka_client_order.VO;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
@Author Ming Zhou
@Date: 2018/11/16 23:46
*/
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private Map<String,String> data;
}
