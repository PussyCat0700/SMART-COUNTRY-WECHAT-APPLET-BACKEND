package com.miniprogram.zhihuicunwu;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
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
    // http 请求端口，线上配置为 8998
    @Value("${server.port-http}")
    private int serverPortHttp;

    // 服务器运行端口，等同于 HTTPS 请求端口，线上 8999
    @Value("${server.port}")
    private int serverPortHttps;

    /**
     * http重定向到https
     */
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat;
        tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        connector.setScheme("http");
        //Connector监听的http的端口号
        connector.setPort(serverPortHttp);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(serverPortHttps);
        return connector;
    }
}
