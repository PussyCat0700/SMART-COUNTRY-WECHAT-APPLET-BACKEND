package com.miniprogram.zhihuicunwu.config;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
@Component
public class MyContextListener implements ServletContextListener {
    private SSHConnection conexionssh;
    public MyContextListener() {
        super();
    }

    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // 建立连接
        conexionssh = new SSHConnection();
        conexionssh.SSHConnection();
        System.out.println("成功建立SSH连接");
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // 断开连接
        System.out.println("Context destroyed ... !\n\n\n");
        try {
            conexionssh.closeSSH(); // disconnect
            System.out.println("\n\n\n成功断开SSH连接!\n\n\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n\n断开SSH连接出错！\n\n\n");
        }
    }
}
