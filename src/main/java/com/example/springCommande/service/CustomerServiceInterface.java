package com.example.springCommande.service;

import com.example.springCommande.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerServiceInterface {
    CustomerDto createCustomer(CustomerDto customerDto);
    Page<CustomerDto> getAllCustomers(Pageable pageable);
    CustomerDto getCustomerById(Long id);
    CustomerDto getCustomerByPhoneNumber(String phoneNumber);
}
