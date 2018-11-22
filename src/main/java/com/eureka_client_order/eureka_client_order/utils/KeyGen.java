package com.eureka_client_order.eureka_client_order.utils;

import java.util.Random;

/*
@Author Ming Zhou
@Date: 2018/11/16 16:16
*/
public class KeyGen {
    public static synchronized  String genUniKey(){
        // need more complex algo
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
