package com.producer.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(value = "com.schedulercommon.dao") //扫描mapper位置
@EnableSwagger2  //支持Swagger2 注解
public class SpringCloudClientProducerApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudClientProducerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientProducerApplication.class, args);
        logger.info("swaggerUrl:http://127.0.0.1:8711/swagger-ui.html#");
    }

}
