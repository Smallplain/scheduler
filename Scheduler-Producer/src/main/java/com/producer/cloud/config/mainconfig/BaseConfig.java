package com.producer.cloud.config.mainconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@Data
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public  class BaseConfig {

    @Value("${email.all}")
    public  String emailMainConfig;
    @Value("${hello}")
    public  String hello;
    @Value("${scheduler-eureka}")
    public  String SCHEDULER_EUREKA;
    @Value("${scheduler-config}")
    public  String SCHEDULER_CONFIG;
    @Value("${scheduler-zuul}")
    public  String SCHEDULER_ZUUL;
    @Value("${scheduler-producer}")
    public  String SCHEDULER_PRODUCER;
    @Value("${scheduler-consumer}")
    public  String SCHEDULER_CONSUMER;

}
