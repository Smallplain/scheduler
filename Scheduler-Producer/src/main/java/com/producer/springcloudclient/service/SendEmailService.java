package com.producer.springcloudclient.service;

public interface  SendEmailService {
    // 发送邮件
    boolean sendmail(String toPeopleName,String mailTitle,String content,String emailType);
}
