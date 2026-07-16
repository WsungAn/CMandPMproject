package com.example.cmandpmproject.order.service;

import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import com.example.cmandpmproject.order.dto.*;
import com.example.cmandpmproject.order.entity.Order;
import com.example.cmandpmproject.order.repository.OrderRepository;
import com.example.cmandpmproject.product.entity.Product;
import com.example.cmandpmproject.product.entity.ProductStatus;
import com.example.cmandpmproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;
    private final ProductRepository productRepository;

    @Transactional
    public CreateOrderResponse save(CreateOrderRequest request) {

        // TODO: 인증 기능과 연결 후 로그인 관리자 사용
        Admin admin = null;

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new IllegalStateException("해당 고객은 없는 고객입니다.")
                );

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() ->
                        new IllegalStateException("해당 상품은 없는 상품입니다.")
                );

        // TODO: 상품 담당자가 아래 메서드를 완성하면 연결
        // product.validateOrderable();
        // product.decreaseStock(request.getQuantity());

        Order order = new Order(
                request.getQuantity(),
                admin,
                customer,
                product
        );

        Order savedOrder = orderRepository.save(order);

        return new CreateOrderResponse(
                savedOrder.getId(),
                savedOrder.getProduct().getId(),
                savedOrder.getCustomer().getId(),
                savedOrder.getAdmin() == null
                        ? null
                        : savedOrder.getAdmin().getId(),
                savedOrder.getQuantity(),
                savedOrder.getTotalPrice(),
                savedOrder.getOrderNo(),
                savedOrder.getOrderStatus(),
                savedOrder.getCreatedAt(),
                savedOrder.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetAllOrderResponse> getOrders(
            OrderSearchCondition condition
    ) {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> new GetAllOrderResponse(
                        order.getId(),
                        order.getCustomer().getId(),
                        order.getCustomer().getEmail(),
                        order.getOrderNo(),
                        order.getProduct().getId(),
                        order.getQuantity(),
                        order.getTotalPrice(),
                        order.getCreatedAt(),
                        order.getOrderStatus(),
                        order.getAdmin()
                ))
                .toList();
    }

    @Transactional(readOnly = true)
    public GetOrderResponse getOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new IllegalStateException("없는 주문정보입니다.")
                );

        Admin admin = order.getAdmin();

        return new GetOrderResponse(
                order.getId(),
                order.getOrderNo(),
                order.getCustomer().getId(),
                order.getCustomer().getEmail(),
                order.getProduct().getId(),
                order.getQuantity(),
                order.getTotalPrice(),
                order.getCreatedAt(),
                order.getOrderStatus(),
                admin == null ? null : admin.getId(),
                admin == null ? null : admin.getEmail(),
                admin == null ? null : admin.getRole()
        );
    }
}