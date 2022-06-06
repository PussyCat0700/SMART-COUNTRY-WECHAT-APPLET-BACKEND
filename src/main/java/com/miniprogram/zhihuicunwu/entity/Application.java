package com.miniprogram.zhihuicunwu.entity;

import java.io.Serializable;

/**
 * (Application)实体类
 *
 * @author makejava
 * @since 2022-06-06 11:42:26
 */
public class Application implements Serializable {
    private static final long serialVersionUID = -77466091038644126L;
    
    private Integer applicationId;
    
    private Integer usergaid;
    
    private String name;
    
    private Integer gender;
    
    private String phone;
    
    private String address;


    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getUsergaid() {
        return usergaid;
    }

    public void setUsergaid(Integer usergaid) {
        this.usergaid = usergaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

