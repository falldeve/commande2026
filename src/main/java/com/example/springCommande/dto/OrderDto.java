package com.example.springCommande.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    private Long id;
    private String ref;
    private LocalDate date;
    private Double amount;
    private CustomerDto customer;
    private List<ProductDto> products;

}
