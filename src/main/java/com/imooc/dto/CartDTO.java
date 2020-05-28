package com.imooc.dto;

import lombok.Data;

@Data
public class CartDTO {

    //商品ID
    private String ProductId;

    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        ProductId = productId;
        this.productQuantity = productQuantity;
    }
}
