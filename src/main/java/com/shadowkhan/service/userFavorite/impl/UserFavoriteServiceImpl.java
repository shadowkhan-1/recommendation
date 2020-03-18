package com.shadowkhan.service.userFavorite.impl;

import com.shadowkhan.dao.userFavorite.UserFavoriteMapper;
import com.shadowkhan.dao.userFavorite.model.UserFavorite;
import com.shadowkhan.dao.userFavorite.model.UserFavoriteEntity;
import com.shadowkhan.dao.userFavorite.req.UserFavoriteReq;
import com.shadowkhan.service.userFavorite.UserFavoriteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

import java.math.BigDecimal;

/**
 * 用户收藏表业务实现
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@Service
public class UserFavoriteServiceImpl implements UserFavoriteService {

    @Autowired
    private UserFavoriteMapper userFavoriteMapper;

    @Override
    public UserFavorite findById(Integer id) {
        return userFavoriteMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserFavorite> findByIds(List<Integer> ids) {
        UserFavoriteEntity userFavoriteEntity = new UserFavoriteEntity();
        userFavoriteEntity.createCriteria().andUserIdIn(ids);
        return userFavoriteMapper.selectByEntitys(userFavoriteEntity);
    }

    @Override
    public Integer create(UserFavoriteReq req) {
        UserFavorite userFavorite = new UserFavorite();
        BeanUtils.copyProperties(req, userFavorite);
        userFavoriteMapper.insertSelective(userFavorite);
        return userFavorite.getUserId();
    }

    @Override
    public void deleteById(Integer id) {
        userFavoriteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        UserFavoriteEntity userFavoriteEntity = new UserFavoriteEntity();
        userFavoriteEntity.createCriteria().andUserIdIn(ids);
        userFavoriteMapper.deleteByEntity(userFavoriteEntity);
    }

    @Override
    public void updateById(UserFavoriteReq req) {
        UserFavorite userFavorite = new UserFavorite();
        BeanUtils.copyProperties(req, userFavorite);
        int result = userFavoriteMapper.updateByPrimaryKeySelective(userFavorite);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }

    @Override
    public List<UserFavorite> findAll(HashMap map) {
        return userFavoriteMapper.selectAll(map);
    }

    @Override
    public UserFavorite findByEntity(UserFavoriteReq req) {
        UserFavoriteEntity userFavoriteEntity = new UserFavoriteEntity();
        BeanUtils.copyProperties(req,userFavoriteEntity);
        userFavoriteEntity.createCriteria().andIsbnEqualTo(req.getIsbn()).andUserIdEqualTo(Integer.valueOf(req.getUserId())).andIsDeletedEqualTo(req.getIsDeleted());
        return userFavoriteMapper.selectByEntity(userFavoriteEntity);
    }

    @Override
    public List<UserFavorite> findByUserId(Integer userId) {
        return  userFavoriteMapper.selectByUserId(userId);
    }

    @Override
    public List<UserFavorite> findByEntitys(UserFavoriteReq req) {
        UserFavoriteEntity userFavoriteEntity = new UserFavoriteEntity();
        BeanUtils.copyProperties(req,userFavoriteEntity);
        userFavoriteEntity.createCriteria().andIsbnEqualTo(req.getIsbn()).andUserIdEqualTo(Integer.valueOf(req.getUserId())).andIsDeletedEqualTo(req.getIsDeleted());
        return userFavoriteMapper.selectByEntitys(userFavoriteEntity);
    }
}
