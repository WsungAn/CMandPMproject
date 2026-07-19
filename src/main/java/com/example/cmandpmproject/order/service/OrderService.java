package com.example.cmandpmproject.order.service;

import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import com.example.cmandpmproject.order.dto.*;
import com.example.cmandpmproject.order.entity.Order;
import com.example.cmandpmproject.order.entity.OrderStatus;
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
        /*TODO: 인증 기능과 연결 후 로그인 관리자 사용*/
        Admin admin = null;

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new IllegalStateException("해당 고객은 없는 고객입니다.")
                );

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() ->
                        new IllegalStateException("해당 상품은 없는 상품입니다.")
                );

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
                savedOrder.getAdmin().getId(),
                savedOrder.getQuantity(),
                savedOrder.getTotalPrice(),
                savedOrder.getOrderNo(),
                savedOrder.getOrderStatus(),
                savedOrder.getCreatedAt(),
                savedOrder.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetAllOrderResponse> getOrders(OrderSearchCondition condition) {
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
                .orElseThrow(() -> new IllegalStateException("없는 주문정보입니다."));

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
                admin.getId(),
                admin.getEmail(),
                admin.getRole().getValue()
        );
    }

    @Transactional
    public void update(Long orderId, OrderStatus nextStatus) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문이 없습니다."));

        OrderStatus currentStatus = order.getOrderStatus();

        if (!currentStatus.canTransitionTo(nextStatus)) {
            throw new IllegalStateException(
                    currentStatus.getValue() + " 상태에서는 "
                            + nextStatus.getValue() + " 상태로 변경할 수 없습니다."
            );
        }
        order.changeStatus(nextStatus);
    }

    @Transactional
    public void cancelOrder(Long orderId, String cancelReason) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문이 없습니다."));

        if (order.getOrderStatus() != OrderStatus.PREPARING) {
            throw new IllegalStateException("준비중인 주문만 취소할 수 있습니다.");
        }

        order.cancel(cancelReason);

        // 주문에 연결된 상품
        Product product = order.getProduct();

        // 재고 복구
        /*product.restoreStock(order.getQuantity());*/

        // 상품 상태 변경
        /*product.updateStatusByStock();*/
    }
}
