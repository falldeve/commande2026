package com.example.springCommande.service;

import com.example.springCommande.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductServiceInterface {
    ProductDto createProduct(ProductDto productDto);
    Page<ProductDto> getAllProducts(Pageable pageable);
    ProductDto updateProductQuantity(Long id, Integer quantity);
    void deleteProduct(Long id);
}
