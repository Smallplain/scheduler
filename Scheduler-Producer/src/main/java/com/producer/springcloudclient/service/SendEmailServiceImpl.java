package com.producer.springcloudclient.service;

import com.producer.springcloudclient.manager.EmailManager;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

@Slf4j
@Service
public class SendEmailServiceImpl implements SendEmailService{
    private static final Logger logger = LoggerFactory.getLogger(SendEmailServiceImpl.class);

    @Override
    public boolean sendmail(String toPeopleName, String mailTitle, String content, String emailType) {
        try {
            EmailManager singleInstance = EmailManager.getSingleInstance();
            JavaMailSenderImpl sender = singleInstance.getMimeMessages(emailType);
            MimeMessage mimeMessage = sender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(Objects.requireNonNull(sender.getUsername()));    // 设置发件人
            mimeMessageHelper.setTo(toPeopleName);  // 设置收件人
            mimeMessageHelper.setSubject(mailTitle);    // 设置主题/标题
            mimeMessageHelper.setText(content,true);     // 设置内容.true:支持html格式
            sender.send(mimeMessageHelper.getMimeMessage());    // 发送邮件
            logger.info("邮件发送成功...");
            return true;
        } catch (MessagingException e) {
            logger.error(String.format("邮件发送 失败 e:{%s}", e));
            return false;
        }
    }


}
