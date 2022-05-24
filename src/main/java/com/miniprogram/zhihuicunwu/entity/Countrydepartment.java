package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Countrydepartment)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:20
 */
public class Countrydepartment implements Serializable {
    private static final long serialVersionUID = 911782033130019571L;

    private Integer did;

    private Integer cid;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}

