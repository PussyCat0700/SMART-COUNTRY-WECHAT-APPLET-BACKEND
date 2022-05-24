package com.miniprogram.zhihuicunwu.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description:
 * @Author: x
 * @Date :
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.miniprogram.zhihuicunwu.web.controller..*(..))")
    public void requestAspect(){}

    @Before(value = "requestAspect()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("====================start====================");
        log.info("IP   ："+request.getRemoteAddr());
        log.info("URL  ："+request.getRequestURL().toString());
        log.info("HTTP Method   ："+request.getMethod());
        log.info("Class Method  ："+joinPoint.getSignature());
        log.info("Request Args  ："+ Arrays.toString(joinPoint.getArgs()));
        log.info("=====================End=====================");
    }
}
