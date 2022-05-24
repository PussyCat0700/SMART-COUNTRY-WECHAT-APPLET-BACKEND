package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Govaffairsspot)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:22
 */
public class Govaffairsspot implements Serializable {
    private static final long serialVersionUID = 344378526949305169L;

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

