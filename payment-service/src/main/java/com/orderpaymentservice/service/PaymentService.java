package com.orderpaymentservice.service;

import com.orderpaymentservice.entity.Payment;
import com.orderpaymentservice.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessesing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcessesing(){
        return new Random().nextBoolean() ? "Success" : "false";

    }

    public Payment findPaymentHistoryByOrderId(Integer orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
