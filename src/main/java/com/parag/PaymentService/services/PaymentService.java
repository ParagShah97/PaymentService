package com.parag.PaymentService.services;

import com.parag.PaymentService.model.PaymentRequest;
import com.parag.PaymentService.model.PaymentResponse;

public interface PaymentService {
    long makePayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetails(long id);
}
