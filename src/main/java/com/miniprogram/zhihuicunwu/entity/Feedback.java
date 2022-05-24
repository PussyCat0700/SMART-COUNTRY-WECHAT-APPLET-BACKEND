package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Feedback)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:22
 */
public class Feedback implements Serializable {
    private static final long serialVersionUID = 568276049027878402L;

    private Integer uid;

    private Integer pid;

    private Date ftime;

    private String fcontent;

    private String freturn;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

    public String getFreturn() {
        return freturn;
    }

    public void setFreturn(String freturn) {
        this.freturn = freturn;
    }

}

