package com.scheduler.api.remote;

import com.scheduler.api.fallback.EmailRemoteFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "scheduler-business",url="http://localhost:8711",fallback = EmailRemoteFallBack.class)
public interface EmailRemote {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/email/send", method = RequestMethod.POST)
    String sendEmail(@RequestParam(value = "toPeopleName") String toPeopleName,
                     @RequestParam(value = "mailTitle") String mailTitle,
                     @RequestParam(value = "content") String content,
                     @RequestParam(value = "emailType") String emailType);
}
