package com.shadowkhan.dao.userFavorite.req;

import java.math.BigDecimal;

/**
 * userFavorite通用请求参数
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public class UserFavoriteReq {

    // 用户id
    private Integer userId;

    // 用户名
    private String username;

    // 图书编码
    private String isbn;

    // 创建时间
    private Long createTime;

    // 是否删除
    private String isDeleted;

    // 版本
    private Integer version;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version){
        this.version = version;
    }

}