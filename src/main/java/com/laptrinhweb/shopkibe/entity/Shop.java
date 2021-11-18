package com.laptrinhweb.shopkibe.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shop")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String img;

    private String address;

    private Long user_id;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    private Boolean isActive;

    public Shop(){

    }
    public Shop(String name, String address, Long user_id) {
        this.name = name;
        this.address = address;
        this.user_id = user_id;
    }
    public Shop(String name, String img, String address, Long user_id) {
        this.name = name;
        this.img = img;
        this.address = address;
        this.user_id = user_id;
    }

    public Shop(Long id, String name, String img, String address, Long user_id) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.address = address;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
