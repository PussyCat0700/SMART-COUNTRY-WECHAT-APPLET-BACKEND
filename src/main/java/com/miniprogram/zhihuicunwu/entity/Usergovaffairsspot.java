package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Usergovaffairsspot)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Usergovaffairsspot implements Serializable {
    private static final long serialVersionUID = -42425667375618364L;
    
    private Integer gasid;
    
    private Integer uid;
    
    private String appointTime;
    
    private Integer status;


    public Integer getGasid() {
        return gasid;
    }

    public void setGasid(Integer gasid) {
        this.gasid = gasid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

