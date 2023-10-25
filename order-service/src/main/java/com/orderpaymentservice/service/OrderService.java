package com.orderpaymentservice.service;

import com.orderpaymentservice.commons.Payment;
import com.orderpaymentservice.commons.TransactionRequest;
import com.orderpaymentservice.commons.TransactionResponse;
import com.orderpaymentservice.entity.Order;
import com.orderpaymentservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;


    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        String message = "";
        Order order =  transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setAmount(order.getPrice());

//        Payment paymentResponse = restTemplate.postForObject("http://localhost:9092/payments/doPayment", payment, Payment.class);
        Payment paymentResponse = restTemplate.postForObject("http://payment-service/payments/doPayment", payment, Payment.class);
        assert paymentResponse != null;
        message = paymentResponse.getPaymentStatus().equals("Success")
            ? "Payment Process Success" : "Failure in Payment Process";

        orderRepository.save(order);
        return new TransactionResponse(
                order,
                paymentResponse.getAmount(),
                paymentResponse.getTransactionId(),
                message
        );
    }
}
