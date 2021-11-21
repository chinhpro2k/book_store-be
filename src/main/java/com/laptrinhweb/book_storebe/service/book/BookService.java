package com.laptrinhweb.book_storebe.service.book;

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

    public List<Book> getAllBooksByAuthorId(long id){
        return bookRepository.findAllByAuthor_Id(id);
    }

//    public List<Book> getFindByName (String name){
//        List<BookItem> bookItems = new ArrayList<>();
//        List<Book> list = new ArrayList<>();
//        if(name.isEmpty()){
//            //
//        }else{
//            list = bookRepository.findByName(name);
//        }
//        return list;
//    }

    public List<BookItem> getAll(){
        List<BookItem> list = new ArrayList<>();
        list = bookRepository.getAll();
        return list;
    }

}
