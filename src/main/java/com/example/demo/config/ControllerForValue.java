package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForValue {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String pwd;

    @RequestMapping("/getParamFromValue")
    public String getParamFromValue(){
        return "username is:" + username + ", pwd is:" + pwd;
    }
}
