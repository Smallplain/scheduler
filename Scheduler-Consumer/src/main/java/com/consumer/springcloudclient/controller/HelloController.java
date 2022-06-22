package com.consumer.springcloudclient.controller;

import com.consumer.springcloudclient.remote.HelloRemote;
import com.springcloudconfig.springcloudconfig.comm.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;

@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class HelloController {
    @Autowired
    HelloRemote helloRemote;

    @Value("${hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name){
      return   helloRemote.hello(name);
    }

}
