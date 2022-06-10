package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Usergovaffairs)实体类
 *
 * @author makejava
 * @since 2022-06-05 15:49:47
 */
public class Usergovaffairs implements Serializable {
    private static final long serialVersionUID = -21502300697049037L;
    
    private Integer gaid;
    
    private Integer uid;

    private Integer did;
    
    private String address;
    
    private Date appointTime;
    
    private String ganame;
    
    private Integer status;
    
    private Integer rate;
    
    private String comment;
    
    private Date createTime;
    
    private String content;
    
    private Integer usergaid;


    public Integer getGaid() {
        return gaid;
    }

    public void setGaid(Integer gaid) {
        this.gaid = gaid;
    }

    public Integer getUid() { return uid; }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDid() { return did; }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public String getGaname() {
        return ganame;
    }

    public void setGaname(String ganame) {
        this.ganame = ganame;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUsergaid() {
        return usergaid;
    }

    public void setUsergaid(Integer usergaid) {
        this.usergaid = usergaid;
    }
}

