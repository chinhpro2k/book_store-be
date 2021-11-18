package com.laptrinhweb.shopkibe.controller;

import com.laptrinhweb.shopkibe.dtos.ProductDTO;
import com.laptrinhweb.shopkibe.entity.Product;
import com.laptrinhweb.shopkibe.entity.Shop;
import com.laptrinhweb.shopkibe.entity.User;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.payload.auth.OTPRequest;
import com.laptrinhweb.shopkibe.repository.ProductRepository;
import com.laptrinhweb.shopkibe.responses.ProductResponse;
import com.laptrinhweb.shopkibe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public ApiResponse createProduct(@RequestBody ProductDTO productDTO){
        return productService.create(productDTO);
    }

    @PutMapping("/update")
    public ApiResponse updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.update(productDTO);
    }

    @GetMapping
    public ProductResponse getAllProduct(){
        return productService.getProducts();
    }

    @PostMapping("/getById")
    public ProductResponse getOneProduct(@RequestBody ProductDTO productDTO){return productService.getProduct(productDTO);}

    @DeleteMapping
    public ApiResponse delete(@RequestBody ProductDTO productDTO) {
        return productService.delete(productDTO);
    }
}
