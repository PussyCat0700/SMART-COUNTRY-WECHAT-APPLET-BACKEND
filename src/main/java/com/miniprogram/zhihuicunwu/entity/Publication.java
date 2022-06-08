package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Publication)实体类
 *
 * @author makejava
 * @since 2022-06-08 21:29:31
 */
public class Publication implements Serializable {
    private static final long serialVersionUID = -53977151753006794L;
    
    private Integer pid;
    
    private String ptype;
    
    private String pcontent;
    
    private Date ptime;
    
    private Integer did;
    
    private String ptitle;
    
    private String pabstract;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPabstract() {
        return pabstract;
    }

    public void setPabstract(String pabstract) {
        this.pabstract = pabstract;
    }

}

