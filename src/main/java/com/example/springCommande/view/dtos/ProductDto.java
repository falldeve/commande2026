package com.example.springCommande.view.dtos;

import lombok.Data;

@Data
public class  ProductDto {
    private Long id;
    private String libelle;
    private Double price;
    private Integer quantity;
}
