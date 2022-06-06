package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Govaffairneed)实体类
 *
 * @author makejava
 * @since 2022-06-06 17:19:03
 */
public class Govaffairneed implements Serializable {
    private static final long serialVersionUID = 382997351885287904L;
    
    private Integer needId;
    /**
     * 涓庝箣鍏宠仈鐨凣ovAffairID
     */
    private Integer needgovaffairid;
    
    private String need;


    public Integer getNeedId() {
        return needId;
    }

    public void setNeedId(Integer needId) {
        this.needId = needId;
    }

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

