package com.shadowkhan.service.userComments;

import com.shadowkhan.dao.userComments.model.UserComments;
import com.shadowkhan.dao.userComments.req.UserCommentsReq;

import java.util.List;
import java.math.BigDecimal;

/**
 * userComments业务接口定义
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public interface UserCommentsService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    UserComments findById(Integer id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    List<UserComments> findByIds(List<Integer> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    Integer create(UserCommentsReq req);

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
    void updateById(UserCommentsReq req);

}