package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Countrydepartment)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Countrydepartment implements Serializable {
    private static final long serialVersionUID = 567033104728370043L;
    
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

