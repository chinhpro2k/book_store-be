package com.laptrinhweb.book_storebe.entity.order;

import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private float totalPrice;
    private float quantity;
    private Long bookItemId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_new_id", referencedColumnName = "id")
    private CustomerNew customer;
}
