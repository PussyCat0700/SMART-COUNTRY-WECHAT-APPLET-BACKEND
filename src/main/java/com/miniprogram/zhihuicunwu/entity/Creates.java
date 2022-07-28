package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Creates)实体类
 *
 * @author makejava
 * @since 2022-07-27 17:31:00
 */
public class Creates implements Serializable {
    private static final long serialVersionUID = -23521498393868198L;

    private Integer uid;

    private Integer cid;

    private Integer passed;


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

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

}

