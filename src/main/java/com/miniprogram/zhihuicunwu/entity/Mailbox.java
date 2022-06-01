package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Mailbox)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Mailbox implements Serializable {
    private static final long serialVersionUID = -17191864294625044L;
    
    private Integer mid;
    
    private Integer did;
    
    private Integer uid;
    
    private String mailcontent;


    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

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

    public String getMailcontent() {
        return mailcontent;
    }

    public void setMailcontent(String mailcontent) {
        this.mailcontent = mailcontent;
    }

}

