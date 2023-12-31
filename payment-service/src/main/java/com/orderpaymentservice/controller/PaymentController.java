package com.orderpaymentservice.controller;

import com.orderpaymentservice.entity.Payment;
import com.orderpaymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }

    @GetMapping("/paymentHistory/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable Integer orderId){
        return  paymentService.findPaymentHistoryByOrderId(orderId);
    }

}
