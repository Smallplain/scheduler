package com.producer.springcloudclient.controller;


import com.producer.springcloudclient.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private SendEmailService emailService;

    @RequestMapping(value = "/email/send", method = RequestMethod.POST)
    public String send(@RequestParam(value = "toPeopleName") String toPeopleName,
                       @RequestParam(value = "mailTitle") String mailTitle,
                       @RequestParam(value = "content") String content,
                       @RequestParam(value = "emailType") String emailType){
        boolean sendmail = emailService.sendmail(toPeopleName, mailTitle, content, emailType);
        if(sendmail){
            return "发送成功！";
        }else {
            return "发送失败！";
        }
    }
}
