package com.example.cmandpmproject.order.entity;

import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.common.BaseEntity;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private String orderNo;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.PREPARING;
    @Column(nullable = false)
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admins_id",nullable = true)
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customers_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "products_id", nullable = false)
    private Product product;

    public Order(Integer quantity, Admin admin, Customer customer, Product product) {
        this.quantity = quantity;
        this.admin = admin;
        this.customer = customer;
        this.product = product;
        this.totalPrice = calculateTotalPrice();
    }

    @PrePersist
    public void generateOrderNo(){
        if (orderNo == null){
            this.orderNo = UUID.randomUUID().toString();
        }
    }

    public int calculateTotalPrice(){
        return /*getProduct.getPrice() * */quantity;
    }

}
