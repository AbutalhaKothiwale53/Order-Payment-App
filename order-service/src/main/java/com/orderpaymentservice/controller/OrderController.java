package com.orderpaymentservice.controller;

import com.orderpaymentservice.commons.Payment;
import com.orderpaymentservice.commons.TransactionRequest;
import com.orderpaymentservice.commons.TransactionResponse;
import com.orderpaymentservice.entity.Order;
import com.orderpaymentservice.service.OrderService;
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
    private TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){
        return orderService.saveOrder(transactionRequest);
    }
}
