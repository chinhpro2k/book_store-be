package com.laptrinhweb.shopkibe.entity;

import javax.persistence.*;

@Entity
@Table(name = "otp")
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    private Long otp;

    public Otp(){

    }

    public Otp(Long user_id, Long otp) {
        this.user_id = user_id;
        this.otp = otp;
    }

    public Otp(Long id, Long user_id, Long otp) {
        this.id = id;
        this.user_id = user_id;
        this.otp = otp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getOtp() {
        return otp;
    }

    public void setOtp(Long otp) {
        this.otp = otp;
    }
}
