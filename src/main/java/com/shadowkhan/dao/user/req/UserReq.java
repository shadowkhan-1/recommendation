package com.shadowkhan.dao.user.req;

import java.math.BigDecimal;

/**
 * user通用请求参数
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public class UserReq {

    // 用户id
    private Integer userId;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 创建时间
    private Long createTime;

    //创建者
    private String createBy;

    // 最近登录
    private Long lastestTime;

    // 是否删除
    private String isDeleted;

    //删除时间
    private Long deletedTime;

    // 用户姓名
    private String name;

    // 用户电话
    private String phone;

    // 用户邮箱
    private String email;

    //用户权限
    private String rule;

    //修改时间
    private Long modifyTime;

    //修改人
    private String modifyBy;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    public Long getLastestTime() {
        return lastestTime;
    }

    public void setLastestTime(Long lastestTime){
        this.lastestTime = lastestTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted){
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Long deletedTime) {
        this.deletedTime = deletedTime;
    }
}
