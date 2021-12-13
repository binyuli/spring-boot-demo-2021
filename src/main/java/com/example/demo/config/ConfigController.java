package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private Environment env;

    @RequestMapping("/getParam")
    public String getParam(){
        return "db.username is:" + env.getProperty("db.username");
    }

    @RequestMapping("/getYmlParam")
    public String getYmlParam(){
        return "db.username is:" + env.getProperty("db.username") + ", db.pwd is:" + env.getProperty("db.pwd");
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
