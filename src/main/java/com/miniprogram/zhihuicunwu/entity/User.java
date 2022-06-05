package com.miniprogram.zhihuicunwu.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:39:27
 */
public class User implements Serializable {
    private static final long serialVersionUID = -75808642801488971L;
    
    private Integer uid;
    
    private Integer status;
    
    private String uname;
    
    private Integer ugender;
    
    private Integer uage;
    
    private String uaddress;
    
    private String uwxid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUgender() {
        return ugender;
    }

    public void setUgender(Integer ugender) {
        this.ugender = ugender;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUwxid() {
        return uwxid;
    }

    public void setUwxid(String uwxid) {
        this.uwxid = uwxid;
    }

    static public User parseFromJSON(JSONObject jsonObject){
        User user = new User();
        user.uname = jsonObject.getString("nickname");
        user.ugender = jsonObject.getInteger("gender");
        user.uaddress = jsonObject.getString("city");
        return user;
    }
    public JSONObject getBriefInfo(){
        JSONObject ret = new JSONObject();
        ret.put("userId", uid);
        ret.put("userName", uname);
        return ret;
    }

}

