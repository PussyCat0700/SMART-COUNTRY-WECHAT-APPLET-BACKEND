package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Resident)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Resident implements Serializable {
    private static final long serialVersionUID = -50992196099220526L;
    
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

