package com.eureka_client_order.eureka_client_order.controller;

import com.eureka_client_order.eureka_client_order.client.ProductClient;
import com.eureka_client_order.eureka_client_order.dto.CartDTO;
import com.eureka_client_order.eureka_client_order.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/*
@Author Ming Zhou
@Date: 2018/11/16 16:48
*/
@RestController
@Slf4j   //for log    //-Dserver.port=8081
public class ClientController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ProductClient productClient;

    //@Autowired    //use config to replace new RestTemplate
    //private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //1 restTemplate
        RestTemplate rt = new RestTemplate();
        ServiceInstance si = loadBalancerClient.choose("MYPRODUCT");
        String url = String.format("http://%s:%s/msg",si.getHost(),si.getPort());
        //String response = rt.getForObject("http://localhost:8081/msg",String.class);
        String response = rt.getForObject(url,String.class);
        log.info("response={}", response);

        //2
        //String response = restTemplate.getForObject(url, String.class);
        //return response;

        //3 use feign to simulate RPC
        String response2 = productClient.myProductMsg();
        return response2;
    }
    @PostMapping("/product/listForOrder")
    public List<ProductInfo> getProductList(){
        //RestTemplate rt = new RestTemplate();
        //List<ProductInfo> productInfoList = rt.postForObject("http://localhost:8081/product/listForOrder",Arrays.asList("1"),List.class);
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("1"));
        log.info("response=", productInfoList);
        return productInfoList;
    }

    @GetMapping("/product/decreaseStock")
    public String prodDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("1",1)));
        return "OK";
    }

}
