package com.laptrinhweb.book_storebe.entity.order;

import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private Date date;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_new_id", referencedColumnName = "id")
    private CustomerNew customer;
}
