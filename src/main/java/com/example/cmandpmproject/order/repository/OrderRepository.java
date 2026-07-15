package com.example.cmandpmproject.order.repository;

import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderNoOrCustomer_Name(
            String orderNo,
            String customerName
    );

    List<Order> orderNo(String orderNo);
}
