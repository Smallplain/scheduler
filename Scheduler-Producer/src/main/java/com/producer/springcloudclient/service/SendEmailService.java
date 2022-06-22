package com.producer.springcloudclient.service;

import org.springframework.stereotype.Service;



public interface  SendEmailService {
    // 发送邮件
    boolean sendmail(String toPeopleName,String mailTitle,String content,String emailType);
}
