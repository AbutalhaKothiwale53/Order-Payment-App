package com.orderpaymentservice.apiGatewayService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {


    private static final String ORDER_SERVICE = "order_service";
    private static final String PAYMENT_SERVICE = "payment_service";

    @CircuitBreaker(name= ORDER_SERVICE, fallbackMethod = "getAllAvailableOrders")
    @RequestMapping("/fallback/orderServiceFallback")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order Service is taking too long to respond or its down. Please try again later");
    }

    @CircuitBreaker(name= PAYMENT_SERVICE, fallbackMethod = "getAllAvailablePayment")
    @RequestMapping("/fallback/paymentServiceFallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment Service is taking too long to respond or its down. Please try again later");
    }
}
