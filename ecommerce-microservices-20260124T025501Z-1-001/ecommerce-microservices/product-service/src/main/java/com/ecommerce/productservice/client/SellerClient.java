package com.ecommerce.productservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "seller-service")
public interface SellerClient {
    // Ideally Seller Service should have this endpoint. Currently it has Auth endpoints.
    // I need to add a generic user/seller endpoint to SellerService later?
    // Or just trust the ID in token? 
    // Requirement says "create communication". So let's assume we want to call it.
    
    @GetMapping("/sellers/{id}")
    Object getSellerById(@PathVariable("id") Long id); // access-protected
}
