package com.laptrinhweb.book_storebe.repository.order;

import com.laptrinhweb.book_storebe.entity.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    @Query(value = "select c from Cart c where c.customer.id = :userId")
    List<Cart> findByUserId(@Param("userId") Long userId);
}
