package com.example.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean addAnotherFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AnotherFilter());
        filterRegistrationBean.addUrlPatterns("/filter/*");
        //order数越小,优先级越高
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean addReqFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ReqFilter());//设置过滤器名称
        filterRegistrationBean.addUrlPatterns("/filter/*");//配置过滤规则
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
}
