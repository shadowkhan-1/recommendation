package com.shadowkhan.service.userComments.impl;

import com.shadowkhan.dao.userComments.UserCommentsMapper;
import com.shadowkhan.dao.userComments.model.UserComments;
import com.shadowkhan.dao.userComments.model.UserCommentsEntity;
import com.shadowkhan.dao.userComments.req.UserCommentsReq;
import com.shadowkhan.service.userComments.UserCommentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import java.math.BigDecimal;

/**
 * 用户评论业务实现
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@Service
public class UserCommentsServiceImpl implements UserCommentsService {

    @Autowired
    private UserCommentsMapper userCommentsMapper;

    @Override
    public UserComments findById(Integer id) {
        return userCommentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserComments> findByIds(List<Integer> ids) {
        UserCommentsEntity userCommentsEntity = new UserCommentsEntity();
        userCommentsEntity.createCriteria().andUserIdIn(ids);
        return userCommentsMapper.selectByEntity(userCommentsEntity);
    }

    @Override
    public Integer create(UserCommentsReq req) {
        UserComments userComments = new UserComments();
        BeanUtils.copyProperties(req, userComments);
        userCommentsMapper.insertSelective(userComments);
        return userComments.getUserId();
    }

    @Override
    public void deleteById(Integer id) {
        userCommentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        UserCommentsEntity userCommentsEntity = new UserCommentsEntity();
        userCommentsEntity.createCriteria().andUserIdIn(ids);
        userCommentsMapper.deleteByEntity(userCommentsEntity);
    }

    @Override
    public void updateById(UserCommentsReq req) {
        UserComments userComments = new UserComments();
        BeanUtils.copyProperties(req, userComments);
        int result = userCommentsMapper.updateByPrimaryKeySelective(userComments);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}