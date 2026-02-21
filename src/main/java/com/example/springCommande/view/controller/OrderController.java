package com.example.springCommande.view.controller;

import com.example.springCommande.view.dtos.OrderDto;
import com.example.springCommande.service.OrderServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrderServiceInterface orderService;

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping
    public Page<OrderDto> getAllOrders(Pageable pageable) {
        return orderService.getAllOrders(pageable);
    }

    @GetMapping("/customer/{phoneNumber}")
    public Page<OrderDto> getOrdersByCustomerPhoneNumber(@PathVariable String phoneNumber, Pageable pageable) {
        return orderService.getOrdersByCustomerPhoneNumber(phoneNumber, pageable);
    }
}
