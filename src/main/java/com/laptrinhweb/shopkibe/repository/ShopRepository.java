package com.laptrinhweb.shopkibe.repository;

import com.laptrinhweb.shopkibe.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query("select p from Shop p")
    ArrayList<Shop> getAllShop();
}
