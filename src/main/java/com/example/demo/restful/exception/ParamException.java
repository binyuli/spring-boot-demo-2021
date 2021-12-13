package com.example.demo.restful.exception;

public class ParamException extends RuntimeException {

    //错误码，一般的http返回码对应
    private Integer errorCode;
    //错误信息
    private String errorMsg;

    public ParamException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
