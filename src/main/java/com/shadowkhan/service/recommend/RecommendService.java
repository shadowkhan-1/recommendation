package com.shadowkhan.service.recommend;

import com.shadowkhan.dao.recommend.model.Recommend;
import com.shadowkhan.dao.recommend.req.RecommendReq;

import java.util.List;
import java.math.BigDecimal;

/**
 * recommend业务接口定义
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public interface RecommendService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    Recommend findById(Integer id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    List<Recommend> findByIds(List<Integer> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    Integer create(RecommendReq req);

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    void deleteById(Integer id);

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    void updateById(RecommendReq req);

}