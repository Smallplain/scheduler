package com.eureka.springcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SchedulerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerEurekaApplication.class, args);
    }

}
