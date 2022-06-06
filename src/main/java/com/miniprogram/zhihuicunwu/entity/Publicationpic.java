package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Publicationpic)实体类
 *
 * @author makejava
 * @since 2022-06-06 16:54:05
 */
public class Publicationpic implements Serializable {
    private static final long serialVersionUID = 743591549923053472L;
    
    private Integer imgId;
    
    private Integer pid;
    
    private String ppic;


    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPpic() {
        return ppic;
    }

    public void setPpic(String ppic) {
        this.ppic = ppic;
    }

}

