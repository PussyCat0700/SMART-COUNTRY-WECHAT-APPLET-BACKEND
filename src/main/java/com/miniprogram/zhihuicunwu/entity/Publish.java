package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Publish)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Publish implements Serializable {
    private static final long serialVersionUID = -50910559143912374L;
    
    private Integer pid;
    
    private Integer did;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

}

