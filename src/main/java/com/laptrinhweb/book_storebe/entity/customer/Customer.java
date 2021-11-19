package com.laptrinhweb.book_storebe.entity.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    public Customer() {
    }

    public Customer(Long id, String sex, String date_of_birth) {
        this.id = id;
        this.sex = sex;
        this.date_of_birth = date_of_birth;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String date_of_birth;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


}
