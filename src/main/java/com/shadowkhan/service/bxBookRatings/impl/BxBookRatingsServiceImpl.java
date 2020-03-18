package com.shadowkhan.service.bxBookRatings.impl;

import com.shadowkhan.dao.bxBookRatings.BxBookRatingsMapper;
import com.shadowkhan.dao.bxBookRatings.model.BxBookRatings;
import com.shadowkhan.dao.bxBookRatings.model.BxBookRatingsEntity;
import com.shadowkhan.dao.bxBookRatings.req.BxBookRatingsReq;
import com.shadowkhan.service.bxBookRatings.BxBookRatingsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import java.math.BigDecimal;

/**
 * 评分表业务实现
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@Service
public class BxBookRatingsServiceImpl implements BxBookRatingsService {

    @Autowired
    private BxBookRatingsMapper bxBookRatingsMapper;

    @Override
    public BxBookRatings findById(Integer id) {
        return bxBookRatingsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BxBookRatings> findByIds(List<Integer> ids) {
        BxBookRatingsEntity bxBookRatingsEntity = new BxBookRatingsEntity();
        bxBookRatingsEntity.createCriteria().andUserIdIn(ids);
        return bxBookRatingsMapper.selectByEntity(bxBookRatingsEntity);
    }

    @Override
    public Integer create(BxBookRatingsReq req) {
        BxBookRatings bxBookRatings = new BxBookRatings();
        BeanUtils.copyProperties(req, bxBookRatings);
        bxBookRatingsMapper.insertSelective(bxBookRatings);
        return bxBookRatings.getUserId();
    }

    @Override
    public void deleteById(Integer id) {
        bxBookRatingsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        BxBookRatingsEntity bxBookRatingsEntity = new BxBookRatingsEntity();
        bxBookRatingsEntity.createCriteria().andUserIdIn(ids);
        bxBookRatingsMapper.deleteByEntity(bxBookRatingsEntity);
    }

    @Override
    public void updateById(BxBookRatingsReq req) {
        BxBookRatings bxBookRatings = new BxBookRatings();
        BeanUtils.copyProperties(req, bxBookRatings);
        int result = bxBookRatingsMapper.updateByPrimaryKeySelective(bxBookRatings);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}