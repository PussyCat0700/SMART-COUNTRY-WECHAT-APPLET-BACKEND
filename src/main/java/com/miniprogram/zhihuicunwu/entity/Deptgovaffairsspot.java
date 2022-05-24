package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Deptgovaffairsspot)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:21
 */
public class Deptgovaffairsspot implements Serializable {
    private static final long serialVersionUID = -20414329064502021L;

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

