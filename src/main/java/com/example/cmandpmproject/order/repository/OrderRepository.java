package com.example.cmandpmproject.order.repository;

import com.example.cmandpmproject.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
