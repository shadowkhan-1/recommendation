package com.shadowkhan.unit.sendemail;

/**
 * @Author: linwei
 * @Description: 封装一个发邮件的接口，后边直接调用即可
 * @Date: Create in 2020/02/22
 * @param: $params$
 * @return: $returns$
 */
public interface IMailService {

    /**
     * 发送文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String to, String subject, String content);



    /**
     * 发送带附件的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);
}
