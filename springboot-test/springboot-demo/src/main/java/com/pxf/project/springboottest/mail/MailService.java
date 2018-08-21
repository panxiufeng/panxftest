package com.pxf.project.springboottest.mail;

/**
 * @ClassName: MailService
 * @Description: TODO
 * @Author panxiufeng
 * @Date 2018/8/11下午11:24
 */
public interface MailService {

    public void sendSimpleMail(String to, String subject, String content);

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
