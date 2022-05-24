package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Publish)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:24
 */
public class Publish implements Serializable {
    private static final long serialVersionUID = 227856391772723351L;

    private Integer pid;

    private Integer did;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

}

