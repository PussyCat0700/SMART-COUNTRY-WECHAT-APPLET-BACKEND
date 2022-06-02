package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Deptgovaffairs)实体类
 *
 * @author makejava
 * @since 2022-06-02 22:26:09
 */
public class Deptgovaffairs implements Serializable {
    private static final long serialVersionUID = 879437842991231414L;
    
    private Integer gaid;
    
    private Integer did;


    public Integer getGaid() {
        return gaid;
    }

    public void setGaid(Integer gaid) {
        this.gaid = gaid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

}

