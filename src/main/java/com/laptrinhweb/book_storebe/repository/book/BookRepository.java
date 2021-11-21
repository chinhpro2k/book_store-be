package com.laptrinhweb.book_storebe.repository.book;

import com.laptrinhweb.book_storebe.entity.book.Book;
import com.laptrinhweb.book_storebe.entity.book.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor_Id(long id);

//    List<Book> findByName(@PathVariable("name") String name);

    @Query(value = "select b.img, b.title, bi.price, bi.amount from BookItem bi, Book b where bi.book.id = b.id")
    List<BookItem> getAll();

}




