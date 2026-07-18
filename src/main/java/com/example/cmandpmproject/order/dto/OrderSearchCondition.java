package com.example.cmandpmproject.order.dto;

import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.product.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.SortDirection;

@Getter
@Setter
public class OrderSearchCondition {
    private String orderNo;
    private Long customerId;
    private int page = 1;
    private int limit = 10;
    private SortBy sortBy = SortBy.DATE;
    private SortOrder sortOrder = SortOrder.DESC;
}