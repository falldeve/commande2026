package com.example.springCommande.mapper;

import com.example.springCommande.dto.OrderDto;
import com.example.springCommande.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ProductMapper.class})
public interface OrderMapper {

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
}
