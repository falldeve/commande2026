package com.example.springCommande.view.dtos;

import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
