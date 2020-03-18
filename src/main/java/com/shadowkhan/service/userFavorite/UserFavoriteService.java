package com.shadowkhan.service.userFavorite;

import com.shadowkhan.dao.user.model.User;
import com.shadowkhan.dao.userFavorite.model.UserFavorite;
import com.shadowkhan.dao.userFavorite.req.UserFavoriteReq;

import java.util.HashMap;
import java.util.List;
import java.math.BigDecimal;

/**
 * userFavorite业务接口定义
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public interface UserFavoriteService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    UserFavorite findById(Integer id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    List<UserFavorite> findByIds(List<Integer> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    Integer create(UserFavoriteReq req);

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
    void updateById(UserFavoriteReq req);


    /**
     * 查询所有的收藏
     * @author linwei
     * @date 2020/02/29
     */

    List<UserFavorite> findAll(HashMap map);


    /**
     * 根据isbn,userId,username查询
     * @author linwei
     * @date 2020/03/01
     */
    List<UserFavorite> findByEntitys(UserFavoriteReq req);

    UserFavorite findByEntity(UserFavoriteReq req);

    List<UserFavorite> findByUserId(Integer userId);

}
