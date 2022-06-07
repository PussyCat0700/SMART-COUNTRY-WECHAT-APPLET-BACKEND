package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Mailbox)实体类
 *
 * @author makejava
 * @since 2022-06-05 14:26:30
 */
public class Mailbox implements Serializable {
    private static final long serialVersionUID = -69521182436785941L;
    
    private Integer mid;

    private Integer uid;
    
    private String mailcontent;

    private Integer cid;


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

    public void setMailcontent(String mailcontent) { this.mailcontent = mailcontent; }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}

