package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Publicationattach)实体类
 *
 * @author makejava
 * @since 2022-06-06 16:53:53
 */
public class Publicationattach implements Serializable {
    private static final long serialVersionUID = 340386053207898657L;
    
    private Integer attachId;
    
    private Integer pid;
    
    private String pattach;


    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPattach() {
        return pattach;
    }

    public void setPattach(String pattach) {
        this.pattach = pattach;
    }

}

