package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Govaffairsarrival)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:22
 */
public class Govaffairsarrival implements Serializable {
    private static final long serialVersionUID = 973254103362936277L;

    private Integer gaaid;

    private Date gaatime;

    private String gaadescription;


    public Integer getGaaid() {
        return gaaid;
    }

    public void setGaaid(Integer gaaid) {
        this.gaaid = gaaid;
    }

    public Date getGaatime() {
        return gaatime;
    }

    public void setGaatime(Date gaatime) {
        this.gaatime = gaatime;
    }

    public String getGaadescription() {
        return gaadescription;
    }

    public void setGaadescription(String gaadescription) {
        this.gaadescription = gaadescription;
    }

}

