package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;
import java.sql.Blob;

/**
 * (Mailboximg)实体类
 *
 * @author makejava
 * @since 2022-06-06 16:09:20
 */
public class Mailboximg implements Serializable {
    private static final long serialVersionUID = -98979248941143540L;
    
    private Integer imgId;
    /**
     * 澶栭敭锛歁ailBoxID
     */
    private Integer mailboxid;
    /**
     * base64褰㈠紡鐩存帴瀛樺偍鍦⊿QL鐨勫浘鐗囨枃浠讹紝涓婇檺16M
     */
    private String imagebase64;


    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

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

