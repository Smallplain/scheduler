package com.producer.springcloudclient.config;

import com.alibaba.fastjson.JSONObject;
import com.producer.springcloudclient.config.mainconfig.EmailMainConfig;
import com.producer.springcloudclient.manager.EmailManager;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;


@Component
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class EmailConfig {
    private static final Logger logger = LoggerFactory.getLogger(EmailConfig.class);

    @Value("${email.all}")
    private String emailMainConfig;

    @PostConstruct
    private  void initEmailSender(){
        List<EmailMainConfig> emailMainConfigs = JSONObject.parseArray(emailMainConfig, EmailMainConfig.class);
        for (EmailMainConfig config:emailMainConfigs){
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(config.getHost());
            mailSender.setPort(config.getPort());
            mailSender.setUsername(config.getUsername());
            mailSender.setPassword(config.getPassword());
            mailSender.setProtocol(config.getProtocol());
            //加认证机制
            Properties javaMailProperties = new Properties();
            javaMailProperties.put("mail.smtp.ssl.enable", config.isSslEnable());
            mailSender.setJavaMailProperties(javaMailProperties);
            EmailManager singleInstance = EmailManager.getSingleInstance();
            singleInstance.addMimeMessages(config.getType(),mailSender);
            logger.info("发送邮件配置信息:{}", config.getType()+ ","+mailSender.getHost() + "," + mailSender.getPort() + "," + mailSender.getUsername() + "," + mailSender.getPassword());
        }
    }
}
