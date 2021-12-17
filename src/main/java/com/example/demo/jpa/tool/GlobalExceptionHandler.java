package com.example.demo.jpa.tool;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamException.class)
    public HttpReturn<String> handlerParamException(ParamException e) {
        HttpCodeEnum httpCodeEnum;
        httpCodeEnum = HttpCodeEnum.PARAM_ERROR;
        return new HttpReturn<>(httpCodeEnum, e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    public HttpReturn<String> handlerOtherException(Exception e) {
        HttpCodeEnum httpCodeEnum;
        httpCodeEnum = HttpCodeEnum.SERVER_ERROR;
        return new HttpReturn<>(httpCodeEnum, e.getMessage());
    }
}
