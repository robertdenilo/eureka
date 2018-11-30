package com.eureka_client_order.eureka_client_order.message;

import com.eureka_client_order.eureka_client_order.entity.ProductInfo;
import com.eureka_client_order.eureka_client_order.entity.ProductInfoOutput;
import com.eureka_client_order.eureka_client_order.utils.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/*
@Author Ming Zhou
@Date: 2018/11/28 21:59
*/
@Component
@Slf4j
@Transactional
public class ProductInfoReceiver {
    private String PROD_STOCK_TEMPLATE = "Prod_Stock_%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String msg){
        List<ProductInfoOutput> pi = (List<ProductInfoOutput>)JsonUtil.fromJsonList(msg,new TypeReference<List<ProductInfoOutput>>(){});
        log.info("Product info: {}",pi);
        for (ProductInfoOutput productInfoOutput : pi) {
            stringRedisTemplate.opsForValue().set(String.format(PROD_STOCK_TEMPLATE,productInfoOutput.getProductId()),String.valueOf(productInfoOutput.getProductStock()));
        }


    }
}
