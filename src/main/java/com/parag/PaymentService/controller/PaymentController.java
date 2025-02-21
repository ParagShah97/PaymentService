package com.parag.PaymentService.controller;

import com.parag.PaymentService.model.PaymentRequest;
import com.parag.PaymentService.model.PaymentResponse;
import com.parag.PaymentService.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> makePayment(@RequestBody PaymentRequest paymentRequest) {
        long id = paymentService.makePayment(paymentRequest);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable long id) {
        PaymentResponse paymentResponse = paymentService.getPaymentDetails(id);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
