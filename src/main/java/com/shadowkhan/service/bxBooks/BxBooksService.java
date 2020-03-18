package com.shadowkhan.service.bxBooks;

import com.shadowkhan.dao.bxBooks.model.BxBooks;
import com.shadowkhan.dao.bxBooks.req.BxBooksReq;

import java.util.HashMap;
import java.util.List;
import java.math.BigDecimal;

/**
 * bxBooks业务接口定义
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public interface BxBooksService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    BxBooks findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    List<BxBooks> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    String create(BxBooksReq req);

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    void deleteById(String id);

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    void deleteByIds(List<String> ids);

    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    void updateById(BxBooksReq req);

    /**
     * 搜索所有的书籍
     * @author linwei
     * @date 2020/02/24
     */

    List<BxBooks> findAll(HashMap map);


    /**
     * 根据keywors搜索
     * @author linwei
     * @date 2020/02/26
     */

    List<BxBooks> findByKeyword(String keywords);

    /**
     * 根据bxbooks查询用户
     * @author linwei
     * @date 2020/03/15
     */

    List<BxBooks> findBxBooks(BxBooksReq bxBooksReq);

}
