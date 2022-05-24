package com.miniprogram.zhihuicunwu.util;

import com.miniprogram.zhihuicunwu.constant.enums.CommonEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description:响应结果集
 * @Author: x
 * @Date :
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "响应信息主体")
@Data
public class Result <T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回标记：成功标记=200，失败标记=400")
    private int code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "数据")
    private T data;

    /**
     * 成功
     */
    public static <T> Result<T> succeed() {
        return restResult(null, CommonEnum.SUCCESS_RESPONSE.getCode(), null);
    }

    public static <T> Result<T> succeed(T data) {
        return restResult(data, CommonEnum.SUCCESS_RESPONSE.getCode(), null);
    }

    public static <T> Result<T> succeed(T data, String msg) {
        return restResult(data, CommonEnum.SUCCESS_RESPONSE.getCode(), msg);
    }

    /**
     * 失败
     */

    public static <T> Result<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }



    private static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public Result(CommonEnum commonEnum, T data) {
        this.code = commonEnum.getCode();
        this.msg = commonEnum.getMsg();
        this.data = data;
    }

    public Result(CommonEnum commonEnum) {
        this.code = commonEnum.getCode();
        this.msg = commonEnum.getMsg();
    }


    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
