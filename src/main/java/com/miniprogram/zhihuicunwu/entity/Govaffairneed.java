package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Govaffairneed)实体类
 *
 * @author makejava
 * @since 2022-06-03 11:40:55
 */
public class Govaffairneed implements Serializable {
    private static final long serialVersionUID = 151504964105654806L;
    /**
     * 与之关联的GovAffairID
     */
    private Integer needgovaffairid;
    
    private String need;


    public Integer getNeedgovaffairid() {
        return needgovaffairid;
    }

    public void setNeedgovaffairid(Integer needgovaffairid) {
        this.needgovaffairid = needgovaffairid;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

}

