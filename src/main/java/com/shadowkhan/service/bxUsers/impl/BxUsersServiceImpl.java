package com.shadowkhan.service.bxUsers.impl;

import com.shadowkhan.dao.bxUsers.BxUsersMapper;
import com.shadowkhan.dao.bxUsers.model.BxUsers;
import com.shadowkhan.dao.bxUsers.model.BxUsersEntity;
import com.shadowkhan.dao.bxUsers.req.BxUsersReq;
import com.shadowkhan.service.bxUsers.BxUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import java.math.BigDecimal;

/**
 * 用户表业务实现
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@Service
public class BxUsersServiceImpl implements BxUsersService {

    @Autowired
    private BxUsersMapper bxUsersMapper;

    @Override
    public BxUsers findById(Integer id) {
        return bxUsersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BxUsers> findByIds(List<Integer> ids) {
        BxUsersEntity bxUsersEntity = new BxUsersEntity();
        bxUsersEntity.createCriteria().andUserIdIn(ids);
        return bxUsersMapper.selectByEntity(bxUsersEntity);
    }

    @Override
    public Integer create(BxUsersReq req) {
        BxUsers bxUsers = new BxUsers();
        BeanUtils.copyProperties(req, bxUsers);
        bxUsersMapper.insertSelective(bxUsers);
        return bxUsers.getUserId();
    }

    @Override
    public void deleteById(Integer id) {
        bxUsersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        BxUsersEntity bxUsersEntity = new BxUsersEntity();
        bxUsersEntity.createCriteria().andUserIdIn(ids);
        bxUsersMapper.deleteByEntity(bxUsersEntity);
    }

    @Override
    public void updateById(BxUsersReq req) {
        BxUsers bxUsers = new BxUsers();
        BeanUtils.copyProperties(req, bxUsers);
        int result = bxUsersMapper.updateByPrimaryKeySelective(bxUsers);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}