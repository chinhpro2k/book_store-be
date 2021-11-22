package com.laptrinhweb.book_storebe.repository.order;

import com.laptrinhweb.book_storebe.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
