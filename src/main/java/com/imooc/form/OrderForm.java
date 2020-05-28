package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderForm {

    @NotNull(message = "姓名必填")
    private String name;

    @NotNull(message = "手机号必填")
    private String phone;

    @NotNull(message = "收货地址必填")
    private String address;

    @NotNull(message = "openid必填")
    private String openid;

    @NotNull(message = "购物车不能为空")
    private String items;
}
