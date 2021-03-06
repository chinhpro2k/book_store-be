package com.laptrinhweb.book_storebe.controller.book;

import com.laptrinhweb.book_storebe.dtos.BookDTO;
import com.laptrinhweb.book_storebe.entity.book.Author;
import com.laptrinhweb.book_storebe.service.book.AuthorService;
import com.laptrinhweb.book_storebe.service.book.BookItemService;
import com.laptrinhweb.book_storebe.service.book.BookService;
import com.laptrinhweb.book_storebe.service.book.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookItemService bookItemService;

    @Autowired
    BookService bookService;
    @Autowired
    private UtilsService utilsService;

    //author
    //hien thi author
    @GetMapping("/author")
    public List<Author> getAuthor(){
        return authorService.getAllAuthor();
    }
    //
    @GetMapping("/author/add")
    public Author getAuthorAdd(){
        Author author = new Author();
        return author;
    }

    @PostMapping("author/add")
    public void postAuthorAdd(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @GetMapping("author/delete/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorService.removeAuthorById(id);
    }

    @PutMapping("author/update/{id}")
    public Author updateAuthor(@PathVariable long id, @RequestBody Author author) {
        return authorService.updateAuthorById(id, author);
    }

    @GetMapping("/all")
    public List<BookDTO> getAllBookItems(){
        return utilsService.getDataBook();
    }

}
