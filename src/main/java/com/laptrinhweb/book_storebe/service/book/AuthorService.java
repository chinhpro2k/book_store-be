package com.laptrinhweb.book_storebe.service.book;

import com.laptrinhweb.book_storebe.entity.book.Author;
import com.laptrinhweb.book_storebe.repository.book.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public Author updateAuthorById(Long id, Author author){
        Author fromDB = authorRepository.findById(id).orElse(null);
        if (fromDB == null)
            return null;
        fromDB.setName(author.getName());
        fromDB.setBiography(author.getBiography());
        return authorRepository.save(fromDB);

    }

    public void removeAuthorById(long id){
        authorRepository.deleteById(id);
    }

    public Optional getAuthorById(long id){
        return authorRepository.findById(id);
    }
}
