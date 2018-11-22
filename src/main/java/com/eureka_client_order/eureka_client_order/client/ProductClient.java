package com.eureka_client_order.eureka_client_order.client;

import com.eureka_client_order.eureka_client_order.dto.CartDTO;
import com.eureka_client_order.eureka_client_order.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/*
@Author Ming Zhou
@Date: 2018/11/16 22:38
*/
@FeignClient(name="MYPRODUCT")
@Component
public interface ProductClient {
    @GetMapping("/msg")
    String myProductMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
