package com.example.springCommande.view.mapper;

import com.example.springCommande.view.dtos.OrderDto;
import com.example.springCommande.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ProductMapper.class})
public interface OrderMapper {

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
}
