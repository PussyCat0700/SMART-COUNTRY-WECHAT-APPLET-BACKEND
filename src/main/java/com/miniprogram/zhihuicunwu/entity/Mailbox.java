package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Mailbox)实体类
 *
 * @author makejava
 * @since 2022-06-28 09:37:57
 */
public class Mailbox implements Serializable {
    private static final long serialVersionUID = 404273825496446168L;
    
    private Integer mid;
    
    private Integer uid;
    
    private String mailcontent;
    
    private Integer cid;
    
    private Integer anonymous;
    
    private Date createTime;


    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMailcontent() {
        return mailcontent;
    }

    public void setMailcontent(String mailcontent) {
        this.mailcontent = mailcontent;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Integer anonymous) {
        this.anonymous = anonymous;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

