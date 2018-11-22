package com.eureka_client_order.eureka_client_order.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eureka_client_order.eureka_client_order.dto.CartDTO;
import com.eureka_client_order.eureka_client_order.dto.OrderDTO;
import com.eureka_client_order.eureka_client_order.entity.OrderDetail;
import com.eureka_client_order.eureka_client_order.form.OrderDetailForm;
import com.eureka_client_order.eureka_client_order.form.OrderForm;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
@Author Ming Zhou
@Date: 2018/11/19 14:49
*/
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm of){
        OrderDTO dto = new OrderDTO();
        dto.setBuyerName(of.getName());
        dto.setBuyerAddr(of.getAddress());
        dto.setBuyerPhone(of.getPhone());
        dto.setBuyerId(of.getOpenId());
        List<OrderDetail> orderdetailList = new ArrayList<>();
        ObjectMapper om = new ObjectMapper();
        List<CartDTO> odfList = null;

        //try {
        //
        //    odfList = om.readValue(of.getItem(), ArrayList.class);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //for(OrderDetailForm odf:odfList){
        //    OrderDetail od = new OrderDetail();
        //    od.setProductId(odf.getProductId());
        //    od.setProductQuantity(Integer.valueOf(odf.getProductQuantity()));
        //    orderdetailList.add(od);
        //}

        JSONArray arry  = JSONArray.parseArray(of.getItem());
        for(int i = 0;i<arry.size();i++){
            JSONObject obj= (JSONObject) arry.get(i);
            String productId =  obj.getString("productId");
            String productQuantity =  obj.getString("productQuantity");
            OrderDetail od = new OrderDetail();
            od.setProductId(productId);
            od.setProductQuantity(Integer.valueOf(productQuantity));
            orderdetailList.add(od);
        }
        dto.setOrderDetailList(orderdetailList);
        return dto;
    }
}
