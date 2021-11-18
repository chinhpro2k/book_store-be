package com.laptrinhweb.shopkibe.repository;


import com.laptrinhweb.shopkibe.entity.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {
    @Query("select w from WareHouse w")
    ArrayList<WareHouse> getAllWarehouse();
}
