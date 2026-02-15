package com.example.springCommande.mapper;

import com.example.springCommande.dto.ProductDto;
import com.example.springCommande.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
