package com.miniprogram.zhihuicunwu.exception;

import com.miniprogram.zhihuicunwu.util.Result;
import com.miniprogram.zhihuicunwu.util.SystemCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: x
 * @Date :
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@RestControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class RestExceptionHandler {
    /**
     * 未能捕获的异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.warn("未知异常:{}", e.getMessage());
        log.error("未知异常:{}", e);
        return Result.fail(SystemCode.FAILURE_CODE, "服务器内部错误");
    }

    /**
     * 方法不支持
     */
    @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
    public Result handleMethodException(Exception e){
        log.warn("请求方式错误:{}", e.getMessage());
        return Result.fail(SystemCode.METHOD_NOT_SUPPORTED_CODE, "请求方法错误");
    }

    /**
     * 捕获实体类抛出的异常
     */
    @ExceptionHandler(EntityExceptions.class)
    public Result handleServiceException(EntityExceptions e) {
        log.warn("实体类抛出异常:{}", e.getMessage());
        return Result.fail(e.getCode(), e.getMsg());
    }
}
