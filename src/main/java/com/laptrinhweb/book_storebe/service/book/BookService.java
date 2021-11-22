package com.laptrinhweb.book_storebe.service.book;

import com.laptrinhweb.book_storebe.dtos.BookDTO;
import com.laptrinhweb.book_storebe.entity.book.Book;
import com.laptrinhweb.book_storebe.entity.book.BookItem;
import com.laptrinhweb.book_storebe.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void removeBookById(long id){
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(long id){
        return bookRepository.findById(id);
    }




}
