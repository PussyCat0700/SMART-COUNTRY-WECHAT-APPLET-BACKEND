package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Country)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Country implements Serializable {
    private static final long serialVersionUID = -60058354467691693L;
    
    private Integer cid;
    
    private Integer score;
    
    private String location;
    
    private String cname;

    private String ccode;

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

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

}

