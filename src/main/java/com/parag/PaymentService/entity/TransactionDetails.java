package com.parag.PaymentService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
public class TransactionDetails {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name="MODE")
    private String paymentMode;

    @Column(name="REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name="STATUS")
    private String paymentStatus;

    @Column(name="PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name="AMOUNT")
    private long amount;

    public TransactionDetails() {
    }

    public TransactionDetails(long orderId, String paymentMode, String referenceNumber, String paymentStatus, Instant paymentDate, long amount) {
//        this.id = id;
        this.orderId = orderId;
        this.paymentMode = paymentMode;
        this.referenceNumber = referenceNumber;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
