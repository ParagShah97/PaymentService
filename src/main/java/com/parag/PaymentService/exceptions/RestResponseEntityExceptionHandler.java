package com.parag.PaymentService.exceptions;

import com.parag.PaymentService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PaymentCustomException.class)
    public ResponseEntity<ErrorResponse> handlePaymentCustomException(PaymentCustomException paymentCustomException) {
        return new ResponseEntity<>(new ErrorResponse(paymentCustomException.getMessage(),
                paymentCustomException.getErrorCode()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
