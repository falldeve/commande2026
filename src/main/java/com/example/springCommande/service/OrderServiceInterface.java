package com.example.springCommande.service;

import com.example.springCommande.view.dtos.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderServiceInterface {
    OrderDto createOrder(OrderDto orderDto);
    Page<OrderDto> getAllOrders(Pageable pageable);
    Page<OrderDto> getOrdersByCustomerPhoneNumber(String phoneNumber, Pageable pageable);
}
