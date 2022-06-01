package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Deptgovaffairsarrival)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Deptgovaffairsarrival implements Serializable {
    private static final long serialVersionUID = 507050511540799496L;
    
    private Integer gaaid;
    
    private Integer did;


    public Integer getGaaid() {
        return gaaid;
    }

    public void setGaaid(Integer gaaid) {
        this.gaaid = gaaid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

}

