package com.laptrinhweb.book_storebe.service.book;

import antlr.StringUtils;
import com.laptrinhweb.book_storebe.entity.book.Book;
import com.laptrinhweb.book_storebe.entity.book.BookItem;
import com.laptrinhweb.book_storebe.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<Book> getAllBooksByAuthorId(long id){
        return bookRepository.findAllByAuthor_Id(id);
    }

    public List<BookItem> getFindByName (@PathVariable("title") String title){
        List<BookItem> list = new ArrayList<>();
        list = bookRepository.findByName(title);
        return list;
    }

}
