package com.miniprogram.zhihuicunwu.constant.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: x
 * @Date :
 */

public enum CommonEnum {

    //成功

    SUCCESS_RESPONSE(200, "成功"),
    //失败

    FAILED_RESPONSE(400, "失败");

    @Setter
    @Getter
    private Integer code;

    @Setter
    @Getter
    private String msg;


    CommonEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
