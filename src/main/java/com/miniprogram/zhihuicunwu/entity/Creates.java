package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Creates)ʵ����
 *
 * @author makejava
 * @since 2022-06-15 21:17:04
 */
public class Creates implements Serializable {
    private static final long serialVersionUID = 956084124609408287L;
    
    private Integer uid;
    
    private Integer cid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}

