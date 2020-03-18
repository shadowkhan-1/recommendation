package com.shadowkhan.service.user;

import com.shadowkhan.dao.user.model.User;
import com.shadowkhan.dao.user.req.UserReq;

import java.util.HashMap;
import java.util.List;
import java.math.BigDecimal;

/**
 * user业务接口定义
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public interface UserService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    User findById(Integer id);

    /**
     * 根据用户名查询
     * @author linwei
     * @date 2020/02/20 14:08
     */
    User findByUsername(HashMap map);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    List<User> findByIds(List<Integer> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    Integer create(UserReq req);

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
    void updateById(UserReq req);

    /**
     * 查询所有的用户
     * @author linwei
     * @date 2020/03/03
     */
    List<User> findAll(HashMap map);

    /**
     * 根据关键字搜索用户
     * @author linwei
     * @date 2020/03/04
     */

    List<User> findByKeywords(HashMap map);

}
