package com.example.springCommande.controller;

import com.example.springCommande.dto.ProductDto;
import com.example.springCommande.service.ProductServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceInterface productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping
    public Page<ProductDto> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @PutMapping("/{id}/quantity")
    public ProductDto updateProductQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        return productService.updateProductQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
