package com.ecommerce.ai.client;

import com.ecommerce.ai.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductDTO> getAllProducts();
    
    @GetMapping("/products/seller/{sellerId}")
    List<ProductDTO> getProductsBySeller(@PathVariable("sellerId") Long sellerId);
}
