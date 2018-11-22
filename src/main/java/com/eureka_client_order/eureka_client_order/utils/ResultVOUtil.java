package com.eureka_client_order.eureka_client_order.utils;

import com.eureka_client_order.eureka_client_order.VO.OrderVO;
import com.eureka_client_order.eureka_client_order.VO.ResultVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
@Author Ming Zhou
@Date: 2018/11/19 14:34
*/
public class ResultVOUtil {

    public static ResultVO<Map<String,String>> success(Object obj){
        ResultVO<Map<String,String>> rvo =  new ResultVO<>();
        rvo.setData((Map<String, String>) obj);
        rvo.setCode(0);
        rvo.setMsg("Successful");
        return rvo;
    }
}
