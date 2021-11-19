package com.laptrinhweb.book_storebe.entity.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    public Account() {

    }

    public Account(Long id, String userName, String password, Long memberId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.memberId = memberId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String userName;
    private String password;
    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
