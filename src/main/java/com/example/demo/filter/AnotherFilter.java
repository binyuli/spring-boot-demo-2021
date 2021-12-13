package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

public class AnotherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AnotherFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AnotherFilter doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("AnotherFilter destroy");
    }
}
