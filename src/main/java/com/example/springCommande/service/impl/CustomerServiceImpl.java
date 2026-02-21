package com.example.springCommande.service.impl;

import com.example.springCommande.view.dtos.CustomerDto;
import com.example.springCommande.entity.Customer;
import com.example.springCommande.view.exception.ResourceNotFoundException;
import com.example.springCommande.view.mapper.CustomerMapper;
import com.example.springCommande.repository.CustomerRepository;
import com.example.springCommande.service.CustomerServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerServiceInterface {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public Page<CustomerDto> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable).map(customerMapper::toDto);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("client non trouver avec l'id: " + id));
    }

    @Override
    public CustomerDto getCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("client non trouver avec ce numero: " + phoneNumber));
    }
}
