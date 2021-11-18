package com.laptrinhweb.shopkibe.repository;

import com.laptrinhweb.shopkibe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p")
    ArrayList<Product> getAllProduct();

    @Query("select p from Product p where p.warehouse_id=?1")
    ArrayList<Product> getProductInWarehouse(Long id);
}