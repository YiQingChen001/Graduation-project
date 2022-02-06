package com.pcc.booking.error;

/**
 * 自定义枚举异常类
 */
public enum EmBusinessError implements CommonError{


    MOIVE_NOT_EXIST(100,"电影不存在"),
    PARAMETER_VALIDATION_ERROR(200,"参数不合法"),
    UNKNOWN_ERROR(500,"未知错误");

    private int errorCode;
    private String errorMessage;

    EmBusinessError(int errorCode, String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public CommonError setErrorMessage(String message) {
        this.errorMessage=message;
        return this;
    }
}
