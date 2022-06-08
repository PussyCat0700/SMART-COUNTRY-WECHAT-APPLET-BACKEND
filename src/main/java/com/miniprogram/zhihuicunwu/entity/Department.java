package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 660357713065666914L;
    
    private Integer did;

    private Integer cid;
    
    private String dname;
    
    private String ddescription;
    
    private String daddress;

    private String dphone;


    public Integer getDid() { return did; }

    public void setDid(Integer did) { this.did = did; }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdescription() {
        return ddescription;
    }

    public void setDdescription(String ddescription) {
        this.ddescription = ddescription;
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress;
    }

    public String getDphone() { return dphone; }

    public void setDphone(String dphone) { this.dphone = dphone; }

}

