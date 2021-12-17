package com.example.demo.jpa;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.example.demo.jpa.controller.*.*(..))")
    private void printLog() {
    }

    @Around("printLog()")
    private Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        logger.info("Param: {}", args);
        Object ret = joinPoint.proceed(args);
        logger.info("Response: {}", ret);
        return ret;
    }
}
