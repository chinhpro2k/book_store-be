package com.laptrinhweb.book_storebe.entity.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer_new")
public class CustomerNew extends Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String newMemberVoucher;

    public String getNewMemberVoucher() {
        return newMemberVoucher;
    }

    public void setNewMemberVoucher(String newMemberVoucher) {
        this.newMemberVoucher = newMemberVoucher;
    }
}
