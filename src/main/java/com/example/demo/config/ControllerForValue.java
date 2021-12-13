package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForValue {

    @Value("${db.username}")
    private String username;

    @Value("${db.pwd}")
    private String pwd;

    @RequestMapping("/getParamFromValue")
    public String getParamFromValue(){
        return "db.username is:" + username + ", db.pwd is:" + pwd;
    }
}
