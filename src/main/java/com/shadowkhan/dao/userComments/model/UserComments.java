package com.shadowkhan.dao.userComments.model;

import java.math.BigDecimal;

/**
 * @author 懒猴子CG
 * @date 2020-02-20 13:45:54
 * @email 
 */
public class UserComments {

    // 用户id
    private Integer userId;
    
    // 图书编码
    private String isbn;
    
    // 用户评论
    private String comment;
    
    // 是否删除
    private String isDeleted;
    
    // 创建时间
    private Long createTime;
    
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted){
        this.isDeleted = isDeleted;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

}