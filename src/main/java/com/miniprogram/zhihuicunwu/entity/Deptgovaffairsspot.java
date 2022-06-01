package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Deptgovaffairsspot)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Deptgovaffairsspot implements Serializable {
    private static final long serialVersionUID = -46557960681852235L;
    
    private Integer gasid;
    
    private Integer did;


    public Integer getGasid() {
        return gasid;
    }

    public void setGasid(Integer gasid) {
        this.gasid = gasid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

}

