package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Govaffairs)实体类
 *
 * @author makejava
 * @since 2022-06-02 22:26:10
 */
public class Govaffairs implements Serializable {
    private static final long serialVersionUID = 336052619290951421L;
    
    private Integer gaid;
    
    private Date gatime;
    
    private String gadescription;
    
    private String ganame;
    
    private Integer isarrival;


    public Integer getGaid() {
        return gaid;
    }

    public void setGaid(Integer gaid) {
        this.gaid = gaid;
    }

    public Date getGatime() {
        return gatime;
    }

    public void setGatime(Date gatime) {
        this.gatime = gatime;
    }

    public String getGadescription() {
        return gadescription;
    }

    public void setGadescription(String gadescription) {
        this.gadescription = gadescription;
    }

    public String getGaname() {
        return ganame;
    }

    public void setGaname(String ganame) {
        this.ganame = ganame;
    }

    public Integer getIsarrival() {
        return isarrival;
    }

    public void setIsarrival(Integer isarrival) {
        this.isarrival = isarrival;
    }

}

