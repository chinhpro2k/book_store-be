package com.laptrinhweb.book_storebe.entity.book;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book_item")
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookItem_id")
    private Long id;
    private double price;
    private int amount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;
}
