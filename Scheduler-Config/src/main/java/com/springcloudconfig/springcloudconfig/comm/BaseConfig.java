package com.springcloudconfig.springcloudconfig.comm;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@Data
public class BaseConfig {
    private static final Logger logger = LoggerFactory.getLogger(BaseConfig.class);

    @Value("${email.all}")
    private static String emailMainConfig;

    @Value("${hello}")
    private static String hello;

    @Value("${scheduler-eureka}")
    private static String SCHEDULER_EUREKA;
    @Value("${scheduler-config}")
    private static String SCHEDULER_CONFIG;
    @Value("${scheduler-zuul}")
    private static String SCHEDULER_ZUUL;
    @Value("${scheduler-producer}")
    private static String SCHEDULER_PRODUCER;
    @Value("${scheduler-consumer}")
    private static String SCHEDULER_CONSUMER;

    public static Logger getLogger() {
        return logger;
    }

    public static String getEmailMainConfig() {
        return emailMainConfig;
    }

    public static void setEmailMainConfig(String emailMainConfig) {
        BaseConfig.emailMainConfig = emailMainConfig;
    }

    public static String getHello() {
        return hello;
    }

    public static void setHello(String hello) {
        BaseConfig.hello = hello;
    }

    public static String getSchedulerEureka() {
        return SCHEDULER_EUREKA;
    }

    public static void setSchedulerEureka(String schedulerEureka) {
        SCHEDULER_EUREKA = schedulerEureka;
    }

    public static String getSchedulerConfig() {
        return SCHEDULER_CONFIG;
    }

    public static void setSchedulerConfig(String schedulerConfig) {
        SCHEDULER_CONFIG = schedulerConfig;
    }

    public static String getSchedulerZuul() {
        return SCHEDULER_ZUUL;
    }

    public static void setSchedulerZuul(String schedulerZuul) {
        SCHEDULER_ZUUL = schedulerZuul;
    }

    public static String getSchedulerProducer() {
        return SCHEDULER_PRODUCER;
    }

    public static void setSchedulerProducer(String schedulerProducer) {
        SCHEDULER_PRODUCER = schedulerProducer;
    }

    public static String getSchedulerConsumer() {
        return SCHEDULER_CONSUMER;
    }

    public static void setSchedulerConsumer(String schedulerConsumer) {
        SCHEDULER_CONSUMER = schedulerConsumer;
    }
}
