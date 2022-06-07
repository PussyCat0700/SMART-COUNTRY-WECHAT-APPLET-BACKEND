package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Departmentimg)实体类
 *
 * @author makejava
 * @since 2022-06-07 13:22:44
 */
public class Departmentimg implements Serializable {
    private static final long serialVersionUID = 846009094842853784L;
    
    private Integer imgId;
    
    private Integer did;
    
    private String dpic;


    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDpic() {
        return dpic;
    }

    public void setDpic(String dpic) {
        this.dpic = dpic;
    }

}

