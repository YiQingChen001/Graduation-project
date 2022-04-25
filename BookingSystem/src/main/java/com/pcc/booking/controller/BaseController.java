package com.pcc.booking.controller;

import com.pcc.booking.error.BusinessException;
import com.pcc.booking.error.EmBusinessError;
import com.pcc.booking.reponse.CommonReturnType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *用来处理代码抛出的异常，并返回给前端
 */
@ControllerAdvice
public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handlerException(Exception ex){
        Map<String, Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException businessException=(BusinessException)ex;
            responseData.put("errorCode",businessException.getErrorcode());
            responseData.put("errorMessage",businessException.getErrormeaasge());
        }
        else{
            responseData.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errorMessage",EmBusinessError.UNKNOWN_ERROR.getErrorMessage());
        }
        return new CommonReturnType("fail",responseData);
    }
}
