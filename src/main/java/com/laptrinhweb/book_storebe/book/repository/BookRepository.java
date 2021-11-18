package com.laptrinhweb.book_storebe.book.repository;

import com.laptrinhweb.book_storebe.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select p from Book p")
    ArrayList<Book> getAllBook();

}
