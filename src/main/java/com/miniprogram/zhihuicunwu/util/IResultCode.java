package com.miniprogram.zhihuicunwu.util;

import java.io.Serializable;

/**
 * @Description: 状态码接口
 * @Author: x
 * @Date :
 */
public interface IResultCode extends Serializable {

    /**
     * 返回的code码
     *
     * @return code
     */
    int getCode();

    /**
     * 返回的消息
     *
     * @return 消息
     */
    String getMsg();
}
