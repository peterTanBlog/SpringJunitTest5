package com.example.springjunittest5.controller;

import com.example.springjunittest5.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    IHelloService helloService;
    @GetMapping("/hello")
    public String hello(String name){
        return "hello "+helloService.hello(name);
    }

}
