package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Create)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Create implements Serializable {
    private static final long serialVersionUID = 662053721384861853L;
    
    private Integer uid;
    
    private Integer cid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}

