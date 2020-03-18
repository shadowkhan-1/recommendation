package com.shadowkhan.service.recommend.impl;

import com.shadowkhan.dao.recommend.RecommendMapper;
import com.shadowkhan.dao.recommend.model.Recommend;
import com.shadowkhan.dao.recommend.model.RecommendEntity;
import com.shadowkhan.dao.recommend.req.RecommendReq;
import com.shadowkhan.service.recommend.RecommendService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import java.math.BigDecimal;

/**
 * 图书推荐表业务实现
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendMapper recommendMapper;

    @Override
    public Recommend findById(Integer id) {
        return recommendMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Recommend> findByIds(List<Integer> ids) {
        RecommendEntity recommendEntity = new RecommendEntity();
        recommendEntity.createCriteria().andUserIdIn(ids);
        return recommendMapper.selectByEntity(recommendEntity);
    }

    @Override
    public Integer create(RecommendReq req) {
        Recommend recommend = new Recommend();
        BeanUtils.copyProperties(req, recommend);
        recommendMapper.insertSelective(recommend);
        return recommend.getUserId();
    }

    @Override
    public void deleteById(Integer id) {
        recommendMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        RecommendEntity recommendEntity = new RecommendEntity();
        recommendEntity.createCriteria().andUserIdIn(ids);
        recommendMapper.deleteByEntity(recommendEntity);
    }

    @Override
    public void updateById(RecommendReq req) {
        Recommend recommend = new Recommend();
        BeanUtils.copyProperties(req, recommend);
        int result = recommendMapper.updateByPrimaryKeySelective(recommend);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}