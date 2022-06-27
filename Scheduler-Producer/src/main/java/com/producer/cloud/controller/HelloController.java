package com.producer.cloud.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name){
        return "hello "+name+"，producer is ready";
    }
}
