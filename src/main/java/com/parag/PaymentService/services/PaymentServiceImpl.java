package com.parag.PaymentService.services;

import com.parag.PaymentService.entity.TransactionDetails;
import com.parag.PaymentService.exceptions.PaymentCustomException;
import com.parag.PaymentService.model.PaymentMode;
import com.parag.PaymentService.model.PaymentRequest;
import com.parag.PaymentService.model.PaymentResponse;
import com.parag.PaymentService.repository.TransactionDetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final Logger log = LogManager.getLogger(PaymentServiceImpl.class);

    @Autowired
    TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public long makePayment(PaymentRequest paymentRequest) {
        log.info("Payment details received {}", paymentRequest);
        TransactionDetails transactionDetails = new TransactionDetails(
                paymentRequest.getOrderId(),
                paymentRequest.getPaymentMode().name(),
                paymentRequest.getReferenceNumber(),
                "SUCCESS",
                Instant.now(),
                paymentRequest.getAmount()
        );

        try {
            transactionDetailsRepository.save(transactionDetails);
        } catch (Exception e) {
            throw new PaymentCustomException("Error Occurred while making the payment",
                    "PAYMENT_FAILED");
        }

        log.info("Transaction is completed with id {}", transactionDetails.getId());

        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetails(long id) {
        log.info("Getting the payment details for id {}", id);

//        TransactionDetails transactionDetails;
//        try {
//            transactionDetails = transactionDetailsRepository
//                    .findByOrderId(id);
//        } catch (Exception e) {
//            log.info("Getting error for the payment details for id {}", id);
//            throw new PaymentCustomException("Payment with given order ID not found",
//                    "PAYMENT_DETAILS_NOT_FOUND");
//        }

        TransactionDetails transactionDetails = transactionDetailsRepository
                    .findByOrderId(id)
                .orElseThrow(() -> new PaymentCustomException("Payment with given order ID not found",
                   "PAYMENT_DETAILS_NOT_FOUND"));


        PaymentResponse paymentResponse = new PaymentResponse(
                transactionDetails.getId(),
                transactionDetails.getOrderId(),
                transactionDetails.getPaymentStatus(),
                PaymentMode.valueOf(transactionDetails.getPaymentMode()),
                transactionDetails.getPaymentDate(),
                transactionDetails.getAmount()
        );

        return paymentResponse;
    }
}
