package com.shadowkhan;

import net.sf.json.JSONObject;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 测试类基类
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BaseTest {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 打印测试结果
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    protected void print(Object obj) {
        log.info(JSONObject.fromObject(obj).toString());
    }
}