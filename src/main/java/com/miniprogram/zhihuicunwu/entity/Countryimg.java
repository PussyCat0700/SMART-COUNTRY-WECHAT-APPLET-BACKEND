package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Countryimg)实体类
 *
 * @author makejava
 * @since 2022-06-07 13:21:12
 */
public class Countryimg implements Serializable {
    private static final long serialVersionUID = 174699853192664851L;
    
    private Integer imgId;
    
    private Integer cid;
    
    private String cpic;


    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCpic() {
        return cpic;
    }

    public void setCpic(String cpic) {
        this.cpic = cpic;
    }

}

