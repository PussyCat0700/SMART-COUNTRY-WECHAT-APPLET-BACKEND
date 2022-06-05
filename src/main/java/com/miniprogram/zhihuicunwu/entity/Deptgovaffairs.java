package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Deptgovaffairs)实体类
 *
 * @author makejava
 * @since 2022-06-05 15:53:28
 */
public class Deptgovaffairs implements Serializable {
    private static final long serialVersionUID = 487797785456756144L;
    
    private Integer gaid;
    
    private Integer did;
    
    private Integer deptgovid;


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

    public Integer getDeptgovid() {
        return deptgovid;
    }

    public void setDeptgovid(Integer deptgovid) {
        this.deptgovid = deptgovid;
    }

}

