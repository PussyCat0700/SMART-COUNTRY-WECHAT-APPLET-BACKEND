package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Country)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:20
 */
public class Country implements Serializable {
    private static final long serialVersionUID = -72246872293651561L;

    private Integer cid;

    private Integer score;

    private String location;

    private String cname;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

}

