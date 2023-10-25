package com.orderpaymentservice.controller;

import com.orderpaymentservice.commons.Payment;
import com.orderpaymentservice.commons.TransactionRequest;
import com.orderpaymentservice.commons.TransactionResponse;
import com.orderpaymentservice.entity.Order;
import com.orderpaymentservice.service.OrderService;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/bookOrder")
//    @CircuitBreaker(name = "orderServiceF", fallbackMethod = "getAllAvailableOrders")
    private TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){
        return orderService.saveOrder(transactionRequest);
    }

//    public String getAllAvailableOrders(Exception e) {
//        return "Order Service is taking too long to respond or its down. Please try again later";
//    }
}
