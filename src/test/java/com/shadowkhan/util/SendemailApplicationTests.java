package com.shadowkhan.util;

import com.shadowkhan.unit.sendemail.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendemailApplicationTests {

    /**
     * 注入发送邮件的接口
     */
    @Autowired
    private IMailService mailService;

    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendmail() {
        mailService.sendSimpleMail("linwei@zhengbang.com","主题：你好普通邮件","今天天气怎么样");
    }

    @Test
    public void sendmailHtml(){
        mailService.sendHtmlMail("linwei@zhengbang.com","主题：你好html邮件","<h1>内容：第一html封邮件</h1>");
    }
}


