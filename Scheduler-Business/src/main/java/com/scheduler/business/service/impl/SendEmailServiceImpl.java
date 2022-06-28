package com.scheduler.business.service.impl;

import com.scheduler.business.config.manager.EmailManager;
import com.scheduler.business.service.SendEmailService;
import com.scheduler.common.config.thread.ThreadPoolGroup;
import com.scheduler.model.dao.EmailInfoMapper;
import com.scheduler.model.model.EmailInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Service
public class SendEmailServiceImpl implements SendEmailService {
    private static final Logger logger = LoggerFactory.getLogger(SendEmailServiceImpl.class);

    @Autowired
    private EmailInfoMapper emailInfoMapper;

    @Override
    public boolean sendmail(String toPeopleName, String mailTitle, String content, String emailType) {
        try {
            EmailManager singleInstance = EmailManager.getSingleInstance();
            JavaMailSenderImpl sender = singleInstance.getMimeMessages(emailType);
            if (sender == null) {
                logger.error(String.format("未配置对应类型的邮件系统！"));
                return false;
            }
            MimeMessage mimeMessage = sender.createMimeMessage();
            //这里，在创建对象的时候定义编码格式(utf-8)：
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            mimeMessageHelper.setFrom(Objects.requireNonNull(sender.getUsername()));    // 设置发件人
            mimeMessageHelper.setTo(toPeopleName);             // 设置收件人
            mimeMessageHelper.setSubject(mailTitle);           // 设置主题/标题
            mimeMessageHelper.setText(content,true);      // 设置内容.true:支持html格式
//            mimeMessageHelper.addAttachment(MimeUtility.encodeWord("附件名","utf-8","B"), 你的附件对象);                //  其次，在添加附件的时候，附件名是需要定义编码的

            EmailInfo emailInfo =new EmailInfo();
            emailInfo.setEmaiTitle(mailTitle);
            emailInfo.setEmailContent(content);
            emailInfo.setEmailType(emailType);
            emailInfo.setGmtCreate(new Date());
            emailInfo.setGmtModified(new Date());
            emailInfo.setStatus(0);//发送中
            emailInfoMapper.insertSelective(emailInfo);
            //设置邮件发送状态为发送中
            ThreadPoolGroup.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        sender.send(mimeMessageHelper.getMimeMessage());    // 发送邮件
                        //设置邮件发送状态为发送成功
                        logger.info("邮件发送成功...");
                        emailInfo.setStatus(1);//发送成功
                        emailInfo.setEmailSendTime(new Date());
                        emailInfo.setGmtModified(new Date());
                        emailInfoMapper.updateByPrimaryKeySelective(emailInfo);
                    } catch (MailException e) {
                        e.printStackTrace();
                        logger.error(String.format("邮件发送 失败 e:{%s}", e));
                        emailInfo.setStatus(2);//发送失败
                        emailInfo.setGmtModified(new Date());
                        emailInfoMapper.updateByPrimaryKeySelective(emailInfo);
                    }

                }
            });
            return true;
        } catch (Exception e) {
            //设置邮件发送状态为发送失败
            logger.error(String.format("邮件发送 失败 e:{%s}", e));
            return false;
        }
    }


}
