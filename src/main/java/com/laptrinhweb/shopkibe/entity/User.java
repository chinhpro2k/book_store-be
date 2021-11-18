package com.laptrinhweb.shopkibe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    private Long shop_id;

    @JsonIgnore
    private String password;

    public User() {
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public User(Long id, String phone, String password) {
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    public User(Long id, String phone, String email, Long shop_id, String password) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.shop_id = shop_id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }
}
