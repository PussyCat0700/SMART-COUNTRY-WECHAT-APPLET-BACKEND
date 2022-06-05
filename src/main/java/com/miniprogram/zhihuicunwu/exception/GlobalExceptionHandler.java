package com.miniprogram.zhihuicunwu.exception;

import com.miniprogram.zhihuicunwu.util.Result;
import com.miniprogram.zhihuicunwu.util.SystemCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.MalformedURLException;
import java.sql.SQLSyntaxErrorException;

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
public class GlobalExceptionHandler {
    private Result handleGeneralException(String message, String hint){
        log.warn("{}:{}", hint, message);
        return Result.fail(SystemCode.FAILURE_CODE, hint);
    }
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
     * 请求Body为空
     */
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public Result handleEmptyBodyException(HttpMessageNotReadableException e){
        return handleGeneralException(e.getMessage(), "请求Body格式错误或为空");
    }

    /**
     * JSON错误
     */
    @ExceptionHandler(com.mashape.unirest.http.exceptions.UnirestException.class)
    public Result handleJSONException(Exception e){
        return handleGeneralException(e.getMessage(), "JSON转义失败！");
    }
    @ExceptionHandler(org.springframework.web.HttpMediaTypeException.class)
    public Result handleWrongBodyTypeException(HttpMediaTypeException e){
        return handleGeneralException(e.getMessage(), "请确认数据已经以JSON格式封装至Http请求Body字段中！");
    }
    @ExceptionHandler(BadSqlGrammarException.class)
    public Result handleSQLException(BadSqlGrammarException e){
        return handleGeneralException(e.getMessage(), "SQL语义错误：请检查您传入的数据中是否缺失了主键或更新字段等关键信息");
    }
    /**
     * OCR鉴权错误
     */
    @ExceptionHandler(OCRAccessTokenException.class)
    public Result handleOCRAccessTokenException(OCRAccessTokenException e){
        log.warn("OCR鉴权失败！", e.getMessage());
        return Result.fail(SystemCode.FAILURE_CODE, e.getMsg());
    }
    /**
     * Http网址格式错误
     */
    @ExceptionHandler(java.net.MalformedURLException.class)
    public Result handleNoProtocolException(MalformedURLException e){
        return handleGeneralException(e.getMessage(), "请在网址前指定协议（如http://)，若已指定，请检查网址格式正确性。正确示例：https://baidu-ai.bj.bcebos.com/ocr/ocr.jpg");
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
