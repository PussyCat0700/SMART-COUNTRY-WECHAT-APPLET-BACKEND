package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Work)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:25
 */
public class Work implements Serializable {
    private static final long serialVersionUID = -98250616464696065L;

    private Integer did;

    private Integer uid;

    private String wname;

    private Date wtime;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public Date getWtime() {
        return wtime;
    }

    public void setWtime(Date wtime) {
        this.wtime = wtime;
    }

}

