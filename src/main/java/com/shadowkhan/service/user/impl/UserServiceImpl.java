package com.shadowkhan.service.user.impl;

import com.shadowkhan.dao.user.UserMapper;
import com.shadowkhan.dao.user.model.User;
import com.shadowkhan.dao.user.model.UserEntity;
import com.shadowkhan.dao.user.req.UserReq;
import com.shadowkhan.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

import java.math.BigDecimal;

/**
 * 用户业务实现
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findByUsername(HashMap map) {
        return userMapper.selectByUsername(map);
    }

    @Override
    public List<User> findByIds(List<Integer> ids) {
        UserEntity userEntity = new UserEntity();
        userEntity.createCriteria().andUserIdIn(ids);
        return userMapper.selectByEntity(userEntity);
    }

    @Override
    public Integer create(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        userMapper.insertSelective(user);
        return user.getUserId();
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        UserEntity userEntity = new UserEntity();
        userEntity.createCriteria().andUserIdIn(ids);
        userMapper.deleteByEntity(userEntity);
    }

    @Override
    public void updateById(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }

    @Override
    public List<User> findAll(HashMap map) {
        return userMapper.selectAll(map);
    }

    @Override
    public List<User> findByKeywords(HashMap map) {
        return userMapper.selectByKeys(map);
    }
}
