package com.example.springCommande.view.mapper;

import com.example.springCommande.view.dtos.ProductDto;
import com.example.springCommande.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
