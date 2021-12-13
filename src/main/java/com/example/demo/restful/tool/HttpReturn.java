package com.example.demo.restful.tool;

import java.io.Serializable;

public class HttpReturn<T> implements Serializable {
    //http返回码
    private Integer httpCode;
    //http返回码对应的信息
    private String httpMsg;
    //返回的数据，用泛型定义
    private T data;

    public HttpReturn(HttpCodeEnum httpCodeEnum, T data) {
        this.httpCode = httpCodeEnum.getHttpCode();
        this.httpMsg = httpCodeEnum.getHttpMsg();
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                ", httpCode=" + httpCode +
                ", httpMsg=" + httpMsg +
                ", data='" + data + '\'' +
                '}';
    }


}