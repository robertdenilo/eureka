package com.eureka_client_order.eureka_client_order.service.Impl;

import com.eureka_client_order.eureka_client_order.client.ProductClient;
import com.eureka_client_order.eureka_client_order.dto.CartDTO;
import com.eureka_client_order.eureka_client_order.dto.OrderDTO;
import com.eureka_client_order.eureka_client_order.emun.OrderStatusEnum;
import com.eureka_client_order.eureka_client_order.emun.PayStatusEnum;
import com.eureka_client_order.eureka_client_order.entity.OrderDetail;
import com.eureka_client_order.eureka_client_order.entity.OrderMaster;
import com.eureka_client_order.eureka_client_order.entity.ProductInfo;
import com.eureka_client_order.eureka_client_order.repository.OrderDetailRepository;
import com.eureka_client_order.eureka_client_order.repository.OrderMasterRepository;
import com.eureka_client_order.eureka_client_order.service.OrderService;
import com.eureka_client_order.eureka_client_order.utils.KeyGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/*
@Author Ming Zhou
@Date: 2018/11/16 16:06
*/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO oDTO) {
        List<String> productIdList = oDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);
        log.info("productInfoList:"+productInfoList.get(0).getProductName());
        BigDecimal orderAmt = new BigDecimal(BigInteger.ZERO);
        String orderId = KeyGen.genUniKey();
        for (OrderDetail od : oDTO.getOrderDetailList()) {
            for (ProductInfo pi : productInfoList) {
                if (pi.getProductId().equals(od.getProductId())) {
                    orderAmt = pi.getProductPrice().multiply(new BigDecimal(od.getProductQuantity())).add(orderAmt);
                    BeanUtils.copyProperties(pi, od);
                    od.setOrderId(orderId);
                    od.setDetailId(KeyGen.genUniKey());
                    orderDetailRepository.save(od);
                }
            }
        }

        List<CartDTO> cartDTOList = oDTO.getOrderDetailList().stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        OrderMaster om = new OrderMaster();
        oDTO.setOrderId(orderId);
        BeanUtils.copyProperties(oDTO, om);
        om.setOrderAmount(new BigDecimal(555));
        om.setOrderStatus(OrderStatusEnum.NEW.getCode());
        om.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(om);

        return oDTO;
    }
}
