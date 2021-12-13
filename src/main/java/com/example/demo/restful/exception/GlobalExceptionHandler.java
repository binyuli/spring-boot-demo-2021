package com.example.demo.restful.exception;

import com.example.demo.restful.tool.HttpCodeEnum;
import com.example.demo.restful.tool.HttpReturn;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamException.class)
    public HttpReturn handlerParamException(ParamException e) {
        HttpCodeEnum httpCodeEnum;
        httpCodeEnum = HttpCodeEnum.PARAM_ERROR;
        return new HttpReturn(httpCodeEnum, e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    public HttpReturn handlerOtherException(Exception e) {
        HttpCodeEnum httpCodeEnum;
        // 其他异常，当我们定义了多个异常时，这里可以增加判断和记录
        httpCodeEnum = HttpCodeEnum.SERVER_ERROR;
        return new HttpReturn(httpCodeEnum, e.getMessage());
    }
}
