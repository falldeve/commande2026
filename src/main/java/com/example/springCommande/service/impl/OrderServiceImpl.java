package com.example.springCommande.service.impl;

import com.example.springCommande.dto.OrderDto;
import com.example.springCommande.entity.Order;
import com.example.springCommande.mapper.OrderMapper;
import com.example.springCommande.repository.OrderRepository;
import com.example.springCommande.service.OrderServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderServiceInterface {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public Page<OrderDto> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).map(orderMapper::toDto);
    }

    @Override
    public Page<OrderDto> getOrdersByCustomerPhoneNumber(String phoneNumber, Pageable pageable) {
        return orderRepository.findByCustomerPhoneNumber(phoneNumber, pageable).map(orderMapper::toDto);
    }
}
