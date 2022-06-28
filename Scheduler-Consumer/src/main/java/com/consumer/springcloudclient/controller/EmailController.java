package com.consumer.springcloudclient.controller;

import com.consumer.springcloudclient.remote.EmailRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("CONSUMER-汇总接口")
@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class EmailController {
    @Autowired
    EmailRemote emailRemote;

    @Value("${hello}")
    private String hello;
    @ApiOperation(value = "获取${hello}的配置",httpMethod = "GET")// 为每个handler添加方法功能描述
    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
    @ApiOperation(value ="获取producer的hello方法",httpMethod = "GET")// 为每个handler添加方法功能描述
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name){
      return   emailRemote.hello(name);
    }
    @ApiOperation(value ="调用producer发送一个邮件",httpMethod = "POST")// 为每个handler添加方法功能描述
    @RequestMapping("/email/send")
    public String index(@RequestParam(value = "toPeopleName") String toPeopleName,
                        @RequestParam(value = "mailTitle") String mailTitle,
                        @RequestParam(value = "content") String content,
                        @RequestParam(value = "emailType") String emailType){
        return  emailRemote.sendEmail(toPeopleName,mailTitle,content,emailType);
    }
}
