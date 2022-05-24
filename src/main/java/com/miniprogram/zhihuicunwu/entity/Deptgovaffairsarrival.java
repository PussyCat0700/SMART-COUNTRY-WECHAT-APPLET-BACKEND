package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Deptgovaffairsarrival)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:21
 */
public class Deptgovaffairsarrival implements Serializable {
    private static final long serialVersionUID = 883754314464616514L;

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

