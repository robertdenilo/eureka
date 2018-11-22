package com.eureka_client_order.eureka_client_order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
@Author Ming Zhou
@Date: 2018/11/16 15:04
*/
@Data
@Entity
public class OrderDetail {
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productIcon;
    private Date createTime;
    private Date updateTime;
}
