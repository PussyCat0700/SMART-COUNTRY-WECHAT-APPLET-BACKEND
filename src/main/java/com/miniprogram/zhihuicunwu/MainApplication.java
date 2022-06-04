package com.miniprogram.zhihuicunwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author x
 */
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@MapperScan(basePackages = {"com.miniprogram.zhihuicunwu.dao"})
public class MainApplication {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        SpringApplication.run(MainApplication.class, args);
        System.out.println("启动成功,耗时: " + (System.currentTimeMillis() - time) / 1000 +"s");
    }
}
