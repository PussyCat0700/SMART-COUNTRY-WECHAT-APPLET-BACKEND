package com.miniprogram.zhihuicunwu.entity;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.zhihuicunwu.util.Base64Util;
import com.miniprogram.zhihuicunwu.util.ImageIOUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

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

    private String uphoto;

    private String uphone;

    private Date uCreateTime;

    private String realName;

    private String thirdSessionKey;

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

    public String getUphoto() {
        return uphoto;
    }

    public void setUphoto(String uphoto) {
        this.uphoto = uphoto;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public Date getUCreateTime() {
        return uCreateTime;
    }

    public void setUCreateTime(Date uCreateTime) {
        this.uCreateTime = uCreateTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    static public User parseFromJSON(JSONObject jsonObject) throws IOException {
        User user = new User();
        user.uname = jsonObject.getString("nickName");
        user.ugender = jsonObject.getInteger("gender");
        String wxAvatarUrl = jsonObject.getString("avatarUrl");
        if(wxAvatarUrl!=null){
            user.uphoto = ImageIOUtils.uploadImg(Base64Util.imageUrlToBase64(wxAvatarUrl));
        }
        return user;
    }
    public JSONObject getBriefInfo(){
        JSONObject ret = new JSONObject();
        ret.put("userId", uid);
        ret.put("userName", uname);
        ret.put("avatar", ImageIOUtils.getUrlFromDBRecord(uphoto));
        return ret;
    }

    public String getThirdSessionKey() {
        return thirdSessionKey;
    }

    public void setThirdSessionKey(String thirdSessionKey) {
        this.thirdSessionKey = thirdSessionKey;
    }
}

