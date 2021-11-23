package com.laptrinhweb.book_storebe.entity.customer;


import javax.persistence.*;

@Entity
@Table(name = "customer_member")
public class CustomerMember extends Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String card;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
