package com.miniprogram.zhihuicunwu.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHConnection {
    String user = "root";// 服务器登录名

    String password = "Abc11235813";// 登陆密码

    String host = "114.132.44.9";	// 服务器公网IP

    int port = 22;  // 跳板机ssh开放的接口,ssh通道端口   默认端口 22

    int local_port = 3307; // 这个是本地的端口，选取一个没有占用的port即可

    String remote_host = "数据库所在的服务器ip";// 要访问的mysql所在的ip

    int remote_port = 3306;// 服务器上数据库端口号

    Session session = null;
    /**
     *    建立SSH连接
     */
    public void SSHConnection() throws Exception{
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(local_port, remote_host, remote_port);
        } catch (Exception e) {
            // do something
        }
    }
    /**
     *    断开SSH连接
     */
    public void closeSSH () throws Exception
    {
        this.session.disconnect();
    }

}

