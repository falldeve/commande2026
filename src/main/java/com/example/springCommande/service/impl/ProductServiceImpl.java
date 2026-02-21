package com.example.springCommande.service.impl;

import com.example.springCommande.view.dtos.ProductDto;
import com.example.springCommande.entity.Product;
import com.example.springCommande.view.exception.ResourceNotFoundException;
import com.example.springCommande.view.mapper.ProductMapper;
import com.example.springCommande.repository.ProductRepository;
import com.example.springCommande.service.ProductServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServiceInterface {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public Page<ProductDto> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapper::toDto);
    }

    @Override
    public ProductDto updateProductQuantity(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product non trouver avec l'id: " + id));
        product.setQuantity(quantity);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product non trouver avec l'id: " + id);
        }
        productRepository.deleteById(id);
    }
}
