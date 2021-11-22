package com.laptrinhweb.book_storebe.repository.book;

import com.laptrinhweb.book_storebe.entity.book.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {
    List<BookItem> findAllByBook_Id(long id);
}
