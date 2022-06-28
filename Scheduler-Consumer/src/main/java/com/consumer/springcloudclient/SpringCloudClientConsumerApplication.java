package com.consumer.springcloudclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableFeignClients
//common中有数据库的相关依赖（例如mybatis,tkmapper等），此项目中引用了common，但是没有配置数据库连接。
// 所以加上(exclude= DataSourceAutoConfiguration.class)
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableSwagger2 //支持Swagger2 注解
public class SpringCloudClientConsumerApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudClientConsumerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientConsumerApplication.class, args);
        logger.info("swaggerUrl:http://127.0.0.1:8712/swagger-ui.html#");
    }

}
