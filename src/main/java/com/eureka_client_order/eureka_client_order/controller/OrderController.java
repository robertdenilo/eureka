package com.eureka_client_order.eureka_client_order.controller;

import com.eureka_client_order.eureka_client_order.VO.ResultVO;
import com.eureka_client_order.eureka_client_order.converter.OrderForm2OrderDTOConverter;
import com.eureka_client_order.eureka_client_order.dto.OrderDTO;
import com.eureka_client_order.eureka_client_order.emun.ResultEnum;
import com.eureka_client_order.eureka_client_order.entity.ProductInfo;
import com.eureka_client_order.eureka_client_order.exception.OrderException;
import com.eureka_client_order.eureka_client_order.form.OrderForm;
import com.eureka_client_order.eureka_client_order.service.OrderService;
import com.eureka_client_order.eureka_client_order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;

/*
@Author Ming Zhou
@Date: 2018/11/16 15:59
*/
@RestController
@RequestMapping(value="/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("Create Order: param not correct, order form={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("Order's cart is empty");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        //map.put("orderId",orderDTO.getBuyerName());
        return ResultVOUtil.success(map);

    }
    @PostMapping(value = "/test")
    @ResponseBody
    public OrderForm test(@Valid OrderForm orderForm, BindingResult bindingResult){
        //if (bindingResult.hasErrors()){
        //    for (ObjectError error:bindingResult.getAllErrors()){
        //        return error.getObjectName()+error.getDefaultMessage();
        //    }
        //}
       return orderForm;
        //return new RespEntity(RespCode.SUCCESS, user);
    }

}
