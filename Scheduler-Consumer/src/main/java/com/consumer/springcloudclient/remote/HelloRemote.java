package com.consumer.springcloudclient.remote;

import com.consumer.springcloudclient.fallback.HelloRemoteFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "scheduler-producer",url="http://localhost:8711", fallback = HelloRemoteFallBack.class)
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
