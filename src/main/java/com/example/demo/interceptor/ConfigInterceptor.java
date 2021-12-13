package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {
    @Autowired
    private UrlInterceptor urlInterceptor;

    @Autowired
    private ParaInterceptor paraInterceptor;

    /* log:
    UrlInterceptor, preHandle
    in ParaInterceptor, url is:/interceptor/login/bruce
    login
    (return response to front end)
    ParaInterceptor, postHandle
    UrlInterceptor, postHandle
    ParaInterceptor, afterCompletion
    UrlInterceptor, afterCompletion
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(urlInterceptor).addPathPatterns("/interceptor/**");
        registry.addInterceptor(paraInterceptor).addPathPatterns("/interceptor/login/*");
    }
}
