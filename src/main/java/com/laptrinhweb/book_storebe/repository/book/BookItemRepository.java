package com.laptrinhweb.book_storebe.repository.book;

import com.laptrinhweb.book_storebe.entity.book.BookItem;
import com.laptrinhweb.book_storebe.entity.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {
    List<BookItem> findAllByBook_Id(long id);

    @Query(value = "select c from BookItem c where c.id = 1")
    List<BookItem> searchById(@Param("bookItemId") Long bookItemId);

    List<BookItem> findAll();
}
