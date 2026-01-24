package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private JwtUtil jwtUtil;
    
    // We would inject SellerClient here if we needed to validate Seller exists

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        // Validate token if needed, or rely on Gateway
        // For now, simple add
        return repository.save(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return repository.findAll();
    }
    
    @GetMapping("/seller/{sellerId}")
    public List<Product> getProductsBySeller(@PathVariable Long sellerId) {
        return repository.findBySellerId(sellerId);
    }
}
