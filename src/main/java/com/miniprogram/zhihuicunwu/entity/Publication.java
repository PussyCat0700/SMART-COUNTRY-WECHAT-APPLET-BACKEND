package com.miniprogram.zhihuicunwu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Publication)实体类
 *
 * @author makejava
 * @since 2022-05-24 17:56:23
 */
public class Publication implements Serializable {
    private static final long serialVersionUID = 336863913301506108L;

    private Integer pid;

    private Integer ptype;

    private String pcontent;

    private Object pattach;

    private Date ptime;

    private Object ppic;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public Object getPattach() {
        return pattach;
    }

    public void setPattach(Object pattach) {
        this.pattach = pattach;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Object getPpic() {
        return ppic;
    }

    public void setPpic(Object ppic) {
        this.ppic = ppic;
    }

}

