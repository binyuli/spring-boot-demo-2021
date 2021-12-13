package com.example.demo.restful.tool;

public enum HttpCodeEnum {
    //用枚举的方式定义Http返回码和返回信息
    OK(200, "OK"),
    CREATEOK(201, "CREATEOK"),
    REDIRECT(301, "REDIRECT"),
    PARAM_ERROR(400, "PARAM_ERROR"),
    NOT_FOUND(404, "NOT_FOUND"),
    SERVER_ERROR(500, "SERVER_ERROR");
    //http返回码和返回信息的变量
    private Integer httpCode;
    private String httpMsg;

    //通过构造函数传入http返回码和返回信息
    HttpCodeEnum(Integer code, String msg) {
        this.httpCode = code;
        this.httpMsg = msg;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMsg() {
        return httpMsg;
    }

    public void setHttpMsg(String httpMsg) {
        this.httpMsg = httpMsg;
    }
}