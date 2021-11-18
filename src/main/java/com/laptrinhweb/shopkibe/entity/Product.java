package com.laptrinhweb.shopkibe.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long shop_id;
    @Column
    private String name;
    //    private String img;
    @Column
    private Long price;
    @Column
    private String description;
    //    private int stock;
    @Column
    private String imageUrl;

    @Column
    private Long warehouse_id;


    @Column
    private Boolean isExport;

    public Boolean getExport() {
        return isExport;
    }

    public void setExport(Boolean export) {
        isExport = export;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }


    public Product() {
    }

    public Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

