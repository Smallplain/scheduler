package com.producer.cloud.controller;


import com.producer.cloud.service.SendEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("PRODUCER-邮件接口")
@RestController
public class EmailController {

    @Autowired
    private SendEmailService emailService;

    @ApiOperation(value="发送一个邮件",httpMethod = "POST")// 为每个handler添加方法功能描述
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
