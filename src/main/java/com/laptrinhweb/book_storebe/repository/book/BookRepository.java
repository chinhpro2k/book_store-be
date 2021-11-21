package com.laptrinhweb.book_storebe.repository.book;

import com.laptrinhweb.book_storebe.entity.book.Book;
import com.laptrinhweb.book_storebe.entity.book.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor_Id(long id);

    @Query(value = "select b from Book b, BookItem bi, Author a, Publisher p where b.title like '%:title%' and b.id = bi.book.id and a.id = b.author.id and b.publisher.id = p.id")
    List<BookItem> findByName(@Param("title") String title);

}

//public class BookService implements BookRepository{
//    public List<Book> findAllByAuthor_Id(long id) {
//        List<Book> listBook = new List<Book>()
//        return new List<Book>();
//    }


