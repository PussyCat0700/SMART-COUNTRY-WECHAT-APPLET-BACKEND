package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Resident)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:24
 */
public class Resident implements Serializable {
    private static final long serialVersionUID = 386980201276154666L;

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

