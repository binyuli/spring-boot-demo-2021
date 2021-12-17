package com.example.demo.jpa.tool;

public enum HttpCodeEnum {

    OK(200, "OK"),
    CREATEOK(201, "CREATEOK"),
    REDIRECT(301, "REDIRECT"),
    PARAM_ERROR(400, "PARAM_ERROR"),
    NOT_FOUND(404, "NOT_FOUND"),
    SERVER_ERROR(500, "SERVER_ERROR");

    private Integer httpCode;
    private String httpMsg;

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