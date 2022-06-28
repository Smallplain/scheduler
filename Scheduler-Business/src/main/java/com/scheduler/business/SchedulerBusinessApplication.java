package com.scheduler.business;

import com.scheduler.common.config.swagger.SwaggerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //开启服务提供者或消费者，客户端的支持，用来注册服务或连接到如Eureka之类的注册中心
@MapperScan(value = "com.scheduler.model.dao") //扫描mapper位置
@Import(SwaggerConfig.class) //需要加载到common的SwaggerConfig，因此配置文件不与当前启动类在同一级目录下，所以扫不到，需要手动引用
public class SchedulerBusinessApplication {
    private static Logger logger = LoggerFactory.getLogger(SchedulerBusinessApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SchedulerBusinessApplication.class, args);
        logger.info("swaggerUrl:http://127.0.0.1:8711/swagger-ui.html#");
    }

}
