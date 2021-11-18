package com.laptrinhweb.shopkibe.responses;

import com.laptrinhweb.shopkibe.dtos.ProductDTO;

import java.util.List;

public class ProductResponse {

    public ProductResponse(List<ProductDTO> products) {
        this.products = products;
    }

    public ProductResponse(ProductDTO product) {
        this.product = product;
    }

    private List<ProductDTO> products;

    private ProductDTO product;

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
