package com.shadowkhan.userComments;

import com.shadowkhan.BaseTest;
import com.shadowkhan.service.userComments.UserCommentsService;
import com.shadowkhan.dao.userComments.req.UserCommentsReq;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.math.BigDecimal;

/**
 * 用户评论测试用例
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public class UserCommentsServiceTest extends BaseTest {

    @Autowired
    private UserCommentsService userCommentsService;

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
        userCommentsService.deleteByIds(Arrays.asList(1, 2));
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