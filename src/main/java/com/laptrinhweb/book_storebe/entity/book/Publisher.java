package com.laptrinhweb.book_storebe.entity.book;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "publisher")
public class Publisher{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;
    private String name;
    private String address;
}
