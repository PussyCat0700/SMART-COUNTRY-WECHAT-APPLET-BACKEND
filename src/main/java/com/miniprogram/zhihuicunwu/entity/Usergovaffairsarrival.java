package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Usergovaffairsarrival)实体类
 *
 * @author makejava
 * @since 2022-05-30 21:01:07
 */
public class Usergovaffairsarrival implements Serializable {
    private static final long serialVersionUID = -46646820693580385L;
    
    private Integer gaaid;
    
    private Integer uid;
    
    private String address;
    
    private String appointTime;
    
    private Integer status;


    public Integer getGaaid() {
        return gaaid;
    }

    public void setGaaid(Integer gaaid) {
        this.gaaid = gaaid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

