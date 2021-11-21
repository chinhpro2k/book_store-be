package com.laptrinhweb.book_storebe.entity.book;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "author")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    private String name;
    private String biography;
}
