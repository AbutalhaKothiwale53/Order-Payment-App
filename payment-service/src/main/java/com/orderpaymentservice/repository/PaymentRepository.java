package com.orderpaymentservice.repository;

import com.orderpaymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Integer> {
    Payment findByOrderId(Integer orderId);
}
