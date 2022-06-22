package com.consumer.springcloudclient.fallback;

import com.consumer.springcloudclient.remote.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteFallBack implements HelloRemote {
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "服务器异常，请检查服务器状态！";
    }
}
