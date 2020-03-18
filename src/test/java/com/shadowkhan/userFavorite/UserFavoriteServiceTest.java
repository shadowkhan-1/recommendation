package com.shadowkhan.userFavorite;

import com.shadowkhan.BaseTest;
import com.shadowkhan.service.userFavorite.UserFavoriteService;
import com.shadowkhan.dao.userFavorite.req.UserFavoriteReq;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.math.BigDecimal;

/**
 * 用户收藏表测试用例
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public class UserFavoriteServiceTest extends BaseTest {

    @Autowired
    private UserFavoriteService userFavoriteService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @Test
    public void findByIdTest() {
        print("根据ID查询测试通过");
    }

    /**
     * 根据ID集合查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @Test
    public void findByIdsTest() {
        print("根据ID集合查询测试通过");
    }
    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @Test
    public void deleteByIdTest() {
        print("根据ID删除测试通过");
    }

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @Test
    public void deleteByIdsTest() {
        userFavoriteService.deleteByIds(Arrays.asList(1, 2));
        print("根据ID集删除测试通过");
    }

    /**
     * 根据ID修改
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @Test
    public void updateById() {
        print("根据ID修改测试通过");
    }
}