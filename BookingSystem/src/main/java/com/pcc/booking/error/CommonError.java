package com.pcc.booking.error;

public interface CommonError {
    int getErrorCode();
    String getErrorMessage();
    CommonError setErrorMessage(String message);
}
