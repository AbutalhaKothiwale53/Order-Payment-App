package com.orderpaymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_tb")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private Integer orderId;
    @Column(name = "order_Name")
    private String orderName;
    @Column(name = "order_Quantity")
    private Integer orderQuantity;
    private Double price;
}
