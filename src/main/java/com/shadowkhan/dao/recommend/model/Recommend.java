package com.shadowkhan.dao.recommend.model;

import java.math.BigDecimal;

/**
 * @author 懒猴子CG
 * @date 2020-02-20 13:45:54
 * @email 
 */
public class Recommend {

    // 用户id
    private Integer userId;
    
    // 图书编码
    private String isbn;
    
    // 推荐系数
    private BigDecimal pref;
    
    // 创建时间
    private Long createTime;
    
    // 是否删除
    private String isDeleted;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public BigDecimal getPref() {
        return pref;
    }

    public void setPref(BigDecimal pref){
        this.pref = pref;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted){
        this.isDeleted = isDeleted;
    }

}