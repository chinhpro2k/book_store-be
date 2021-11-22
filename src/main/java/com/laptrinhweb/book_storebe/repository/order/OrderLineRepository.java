package com.laptrinhweb.book_storebe.repository.order;

import com.laptrinhweb.book_storebe.entity.order.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{
}
