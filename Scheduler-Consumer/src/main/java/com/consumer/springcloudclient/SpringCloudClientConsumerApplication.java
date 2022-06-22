package com.consumer.springcloudclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientConsumerApplication.class, args);
    }

}
