package com.eureka_client_order.eureka_client_order.form;

import com.eureka_client_order.eureka_client_order.dto.CartDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/*
@Author Ming Zhou
@Date: 2018/11/16 23:13
*/
@Data
public class OrderForm {
    @NotNull
    private String name;
    @Size(min = 3,max = 8)
    private String phone;
    @Min(5)
    private String address;
    private String openId;
    @NotNull
    private String item;   //List<CartDTO>
    @JsonCreator
    public OrderForm(@JsonProperty("name") String name, @JsonProperty("phone") String phone) {
        this.name = name;
        this.phone = phone;
    }
}
