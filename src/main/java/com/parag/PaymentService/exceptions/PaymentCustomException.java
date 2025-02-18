package com.parag.PaymentService.exceptions;

public class PaymentCustomException extends RuntimeException {

    private String errorCode;

    public PaymentCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
