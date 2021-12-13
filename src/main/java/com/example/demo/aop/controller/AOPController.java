package com.example.demo.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {
    @RequestMapping("/aopDemo")
    public String aopDemo() {
        System.out.println("process /aopDemo request in controller...");
        return "aopDemo";
    }
}
