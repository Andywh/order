package com.joy.order.enums;

import lombok.Getter;

/**
 * Created by Ai Lun on 2019-07-24.
 */
@Getter
public enum  PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
