package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Govaffairsspot)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Govaffairsspot implements Serializable {
    private static final long serialVersionUID = -69890997949746096L;
    
    private Integer gasid;
    
    private Date gastime;
    
    private String gasdescription;


    public Integer getGasid() {
        return gasid;
    }

    public void setGasid(Integer gasid) {
        this.gasid = gasid;
    }

    public Date getGastime() {
        return gastime;
    }

    public void setGastime(Date gastime) {
        this.gastime = gastime;
    }

    public String getGasdescription() {
        return gasdescription;
    }

    public void setGasdescription(String gasdescription) {
        this.gasdescription = gasdescription;
    }

}

