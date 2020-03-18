package com.shadowkhan.dao.bxBookRatings.model;

import java.math.BigDecimal;

/**
 * @author 懒猴子CG
 * @date 2020-02-20 13:45:54
 * @email 
 */
public class BxBookRatings {

    // 用户id
    private Integer userId;
    
    // 图书编码
    private String isbn;
    
    // 用户评分
    private Integer bookRating;
    
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

    public Integer getBookRating() {
        return bookRating;
    }

    public void setBookRating(Integer bookRating){
        this.bookRating = bookRating;
    }

}