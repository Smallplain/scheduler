package com.producer.springcloudclient.manager;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmailManager {
    private static EmailManager emailManager;
    private static Map<String,JavaMailSenderImpl> emailSender;

    private  EmailManager() {
        this.emailSender = emailSender;
        this.emailManager = emailManager;
    }

    public  static EmailManager getSingleInstance(){
        if (emailManager == null){
            synchronized (EmailManager.class){
                if(emailManager == null){
                    emailManager = new EmailManager();
                }
            }
        }
        return emailManager;
    }

    public List<JavaMailSenderImpl> getMimeMessages(){
        if(emailSender == null){
            emailSender = new HashMap<>();
        }
        return emailSender.values().stream().collect(Collectors.toList());
    }

    public JavaMailSenderImpl getMimeMessages(String emailType){
        if(emailSender == null){
            emailSender = new HashMap<>();
            //加载配置生成
            return null;
        }else {
            return emailSender.get(emailType);
        }
    }

    public void addMimeMessages(String key,JavaMailSenderImpl sender){
        if(emailSender == null){
            emailSender = new HashMap<>();
        }
        emailSender.put(key,sender);
    }
}
