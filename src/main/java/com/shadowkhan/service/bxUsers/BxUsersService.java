package com.shadowkhan.service.bxUsers;

import com.shadowkhan.dao.bxUsers.model.BxUsers;
import com.shadowkhan.dao.bxUsers.req.BxUsersReq;

import java.util.List;
import java.math.BigDecimal;

/**
 * bxUsers业务接口定义
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public interface BxUsersService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    BxUsers findById(Integer id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    List<BxUsers> findByIds(List<Integer> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    Integer create(BxUsersReq req);

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
    void updateById(BxUsersReq req);

}