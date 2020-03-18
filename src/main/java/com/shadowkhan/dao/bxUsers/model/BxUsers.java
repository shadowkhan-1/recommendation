package com.shadowkhan.dao.bxUsers.model;

import java.math.BigDecimal;

/**
 * @author 懒猴子CG
 * @date 2020-02-20 13:45:54
 * @email 
 */
public class BxUsers {

    // 用户id
    private Integer userId;
    
    // 用户地址
    private String location;
    
    // 用户年龄
    private Integer age;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

}