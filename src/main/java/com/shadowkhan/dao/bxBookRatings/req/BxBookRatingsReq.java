package com.shadowkhan.dao.bxBookRatings.req;

import java.math.BigDecimal;

/**
 * bxBookRatings通用请求参数
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public class BxBookRatingsReq {

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