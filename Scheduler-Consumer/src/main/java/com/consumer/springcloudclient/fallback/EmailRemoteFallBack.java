package com.consumer.springcloudclient.fallback;

import com.consumer.springcloudclient.remote.EmailRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class EmailRemoteFallBack implements EmailRemote {
    @Override
    public String hello(String name) {
        return "服务器异常，请检查服务器状态！";
    }

    @Override
    public String sendEmail(String toPeopleName, String mailTitle, String content, String emailType) {
        return "服务器异常，请检查服务器状态！";
    }
}
