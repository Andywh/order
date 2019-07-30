package com.joy.order.dataobject;

import lombok.Data;

/**
 * Created by Ai Lun on 2019-07-28.
 */
@Data
public class CartDTO {

    /**
     * 商品 id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
