package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Mailboximg)实体类
 *
 * @author makejava
 * @since 2022-06-03 11:26:26
 */
public class Mailboximg implements Serializable {
    private static final long serialVersionUID = 869275809883451579L;
    /**
     * 外键：MailBoxID
     */
    private Integer mailboxid;
    /**
     * base64形式直接存储在SQL的图片文件，上限16M
     */
    private String imagebase64;


    public Integer getMailboxid() {
        return mailboxid;
    }

    public void setMailboxid(Integer mailboxid) {
        this.mailboxid = mailboxid;
    }

    public String getImagebase64() {
        return imagebase64;
    }

    public void setImagebase64(String imagebase64) {
        this.imagebase64 = imagebase64;
    }

}

