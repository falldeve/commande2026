package com.example.springCommande.view.mapper;

import com.example.springCommande.view.dtos.CustomerDto;
import com.example.springCommande.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
}
