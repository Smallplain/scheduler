package com.scheduler.api;

import com.scheduler.common.config.swagger.SwaggerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@EnableFeignClients
//common中有数据库的相关依赖（例如mybatis,tkmapper等），此项目中引用了common，但是没有配置数据库连接。
// 所以加上(exclude= DataSourceAutoConfiguration.class)
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@Import(SwaggerConfig.class) //需要加载到common的SwaggerConfig，因此配置文件不与当前启动类在同一级目录下，所以扫不到，需要手动引用
public class SchedulerApiApplication {
    private static Logger logger = LoggerFactory.getLogger(SchedulerApiApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SchedulerApiApplication.class, args);
        logger.info("swaggerUrl:http://127.0.0.1:8712/swagger-ui.html#");
    }

}
