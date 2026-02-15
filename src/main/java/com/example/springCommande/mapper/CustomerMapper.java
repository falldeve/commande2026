package com.example.springCommande.mapper;

import com.example.springCommande.dto.CustomerDto;
import com.example.springCommande.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
}
