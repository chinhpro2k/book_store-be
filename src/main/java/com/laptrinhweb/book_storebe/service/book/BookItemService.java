package com.laptrinhweb.book_storebe.service.book;

import com.laptrinhweb.book_storebe.entity.book.BookItem;
import com.laptrinhweb.book_storebe.repository.book.BookItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookItemService {
    @Autowired
    BookItemRepository bookItemRepository;

    public List<BookItem> getAllBookItem(){
        return bookItemRepository.findAll();
    }

    public void addBookItem (BookItem bookItem){
        bookItemRepository.save(bookItem);
    }

    public void removeBookItem (long id){
        bookItemRepository.deleteById(id);
    }

    public Optional<BookItem> getBookItemById(long id){
        return bookItemRepository.findById(id);
    }

    public List<BookItem> getAllBookItemByBookId(long id){
        return bookItemRepository.findAllByBook_Id(id);
    }
}
