package com.parag.PaymentService.services;

import com.parag.PaymentService.model.PaymentRequest;

public interface PaymentService {
    long makePayment(PaymentRequest paymentRequest);
}
