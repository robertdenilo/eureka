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
public class OrderMaster {
     @Id
     private String orderId;
     private String buyerName;
     private String buyerPhone;
     private String buyerAddr;
     private String buyerId;
     private BigDecimal orderAmount;
     private Integer orderStatus;
     private Integer payStatus;
     private Date createTime;
     private Date updateTime;
}
