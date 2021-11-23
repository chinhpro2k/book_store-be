package com.laptrinhweb.book_storebe.dtos;

import lombok.Data;

@Data
public class BookDTO {
    private long id;
    private String img;
    private String title;
    private int amount;
    private double price;
}
