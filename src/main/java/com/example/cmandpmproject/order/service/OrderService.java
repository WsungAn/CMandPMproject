package com.example.cmandpmproject.order.service;

import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import com.example.cmandpmproject.order.dto.*;
import com.example.cmandpmproject.order.entity.Order;
import com.example.cmandpmproject.order.repository.OrderRepository;
import com.example.cmandpmproject.product.entity.Product;
import com.example.cmandpmproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    public OrderRepository orderRepository;
    public CustomerRepository customerRepository;
    public AdminRepository adminRepository;
    public ProductRepository productRepository;

    @Transactional
    public CreateOrderResponse save(CreateOrderRequest request) {

        Admin admin = null;

        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(
                () -> new IllegalStateException("해당 고객은 없는 고객입니다.")
        );

        Product product = productRepository.findById(request.getProductId()).orElseThrow(
                () -> new IllegalStateException("해당 상품은 없는 상품입니다.")
        );

        //상품상세확인


        //수량확인
//        product.validateOrderable();
//        if (product.getStatus() == ProductStatus.ON_SALE){

        //재고차감
//        product.decreaseStock(request.getQuantity());

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
                savedOrder.getAdmin().getId(),
                savedOrder.getQuantity(),
                savedOrder.getTotalPrice(),
                savedOrder.getOrderNo(),
                savedOrder.getOrderStatus(),
                savedOrder.getCreatedAt(),
                savedOrder.getModifiedAt()
        );
    }

//    @Transactional(readOnly = true)
//    public List<GetAllOrderResponse> getOrders(OrderSearchCondition condition) {
//        List<Order> orders = orderRepository.findAllByOrderNoOrCustomer(condition.getOrderNo(),condition.getCustomerId()).orElseThrow(
//                () -> new IllegalStateException("없는 주문번호입니다.")
//        );
//        return orders.stream()
//                .map(order -> new GetAllOrderResponse(
//                        order.getId(),
//                        order.getCustomer().getId(),
//                        order.getCustomer().getEmail(),
//                        order.getOrderNo(),
//                        order.getProduct().getId(),
//                        order.getQuantity(),
//                        order.getTotalPrice(),
//                        order.getCreatedAt(),
//                        order.getOrderStatus(),
//                        order.getAdmin()
//                )).toList();
//    }
//
//    @Transactional(readOnly = true)
//    public GetOrderResponse getOrder(Long orderId) {
//        Order order = orderRepository.findById(orderId).orElseThrow(
//                () -> new IllegalStateException("없는 주문정보입니다.")
//        );
////        [추가]CS 주문이 아닌 고객의 직접 주문인 경우 등록 관리자 정보는 없습니다.
//        return new GetOrderResponse(
//                order.getId(),
//                order.getOrderNo(),
//                order.getCustomer().getId(),
//                order.getCustomer().getEmail(),
//                order.getProduct().getId(),
//                order.getQuantity(),
//                order.getTotalPrice(),
//                order.getCreatedAt(),
//                order.getOrderStatus(),
//                order.getAdmin().getId(),
//                order.getAdmin().getEmail(),
//                order.getAdmin().getRole()
//        );
//    }

}
