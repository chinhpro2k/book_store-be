package com.laptrinhweb.book_storebe.repository;

import com.laptrinhweb.book_storebe.entity.book.Book;
import com.laptrinhweb.book_storebe.entity.order.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    @Query("select p from Shipment p")
    ArrayList<Shipment> getAllProduct();
    @Query("select f from Shipment f where f.id= ?1" )
    ArrayList<Shipment> getShopId(Long id);

}
