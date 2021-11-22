package com.laptrinhweb.book_storebe.entity.order;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_line")
public class OrderLine {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    private int OrderId;
    private int BookItemId;
    private float Quantity;
}
