package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Usergovaffairsarrival)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Usergovaffairsarrival implements Serializable {
    private static final long serialVersionUID = 734167626510758961L;
    
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

