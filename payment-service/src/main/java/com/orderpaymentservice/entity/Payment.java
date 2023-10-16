package com.orderpaymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_Id")
    private Integer paymentId;
    @Column(name = "payment_Status")
    private String paymentStatus;
    @Column(name = "transaction_Id")
    private String transactionId;
    @Column(name = "order_Id")
    private Integer orderId;
    private double amount;
}
