package com.laptrinhweb.book_storebe.service.book;

import com.laptrinhweb.book_storebe.entity.book.Publisher;
import com.laptrinhweb.book_storebe.repository.book.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }

    public void addPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void removePublisher(long id){
        publisherRepository.deleteById(id);
    }

    public Optional getPublisherById(long id){
        return publisherRepository.findById(id);
    }
}
