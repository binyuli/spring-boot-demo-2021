package com.example.demo.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @RequestMapping("/filter/testFilter")
    public String testFilter(){
        System.out.println("testFilter");
        return "testFilter";
    }
}
