package com.shadowkhan.service.bxBookRatings;

import com.shadowkhan.dao.bxBookRatings.model.BxBookRatings;
import com.shadowkhan.dao.bxBookRatings.req.BxBookRatingsReq;

import java.util.List;
import java.math.BigDecimal;

/**
 * bxBookRatings业务接口定义
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public interface BxBookRatingsService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    BxBookRatings findById(Integer id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    List<BxBookRatings> findByIds(List<Integer> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    Integer create(BxBookRatingsReq req);

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
    void updateById(BxBookRatingsReq req);

}