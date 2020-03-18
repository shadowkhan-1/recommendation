package com.shadowkhan.dao.bxBooks.model;

import java.math.BigDecimal;

/**
 * @author 懒猴子CG
 * @date 2020-02-20 13:45:54
 * @email
 */
public class BxBooks {

    // 图书编码
    private String isbn;

    // 图书名称
    private String bookTitle;

    // 图书作者
    private String bookAuthor;

    // 出版日期
    private Integer yearOfPublication;

    // 出版社
    private String publisher;

    // 图书图片s
    private String imageUrlS;

    // 图书图片m
    private String imageUrlM;

    // 图书图片l
    private String imageUrlL;

    //是否删除
    private String isDeleted;

    //删除时间
    private Long deletedTime;

    //修改时间
    private Long modifyTime;

    //修改人
    private String modifyBy;

    // 创建时间
    private Long createTime;

    //创建者
    private String createBy;

    public BxBooks() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication){
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getImageUrlS() {
        return imageUrlS;
    }

    public void setImageUrlS(String imageUrlS){
        this.imageUrlS = imageUrlS;
    }

    public String getImageUrlM() {
        return imageUrlM;
    }

    public void setImageUrlM(String imageUrlM){
        this.imageUrlM = imageUrlM;
    }

    public String getImageUrlL() {
        return imageUrlL;
    }

    public void setImageUrlL(String imageUrlL){
        this.imageUrlL = imageUrlL;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Long deletedTime) {
        this.deletedTime = deletedTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
