package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Feedback)实体类
 *
 * @author makejava
 * @since 2022-06-18 10:38:49
 */
public class Feedback implements Serializable {
    private static final long serialVersionUID = 767212820402977514L;
    
    private Integer uid;
    
    private Integer pid;
    
    private Date ftime;
    
    private String fcontent;
    
    private String freturn;
    
    private Integer fid;
    
    private String ftitle;


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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

}

