package com.miniprogram.zhihuicunwu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public static String absoluteImgPath;
    @Value("${absoluteImgPath}")
    public void setAbsoluteImgPath(String b){
        absoluteImgPath = b;
    }

    public static String sonImgPath;
    @Value("${sonImgPath}")
    public void setSonImgPath(String b){
        sonImgPath = b;
    }

    public static String serverUrl;
    @Value("${server.url}")
    public void setServerUrl(String b){
        serverUrl = b;
    }

    public static String serverPort;
    @Value("${server.port}")
    public void setServerPort(String b){
        serverPort = b;
    }

    public static String appId;
    @Value("${app.id}")
    public void setAppId(String b){
        appId = b;
    }

    public static String appSecret;
    @Value("${app.secret}")
    public void setAppSecret(String b){
        appSecret = b;
    }
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/web/images/");
        registry.addResourceHandler(sonImgPath + "**").addResourceLocations("file:"+absoluteImgPath+sonImgPath);
    }
}