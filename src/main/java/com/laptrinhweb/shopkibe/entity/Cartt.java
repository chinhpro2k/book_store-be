//package com.laptrinhweb.shopkibe.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "cartt")
//
//public class Cartt {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long id;
//
//    //    private Double price ;
//    private Long quantity;
//    private Double sum;
//    @Column(name = "user_id")
//    private Long user_id;
//
//    private Long id_product;
//
//    public Cartt() {
//    }
//
//    public Cartt(Long user_id, Long id_product, Long quantity, Double sum) {
//        this.user_id = user_id;
//
//        this.id_product = id_product;
//        this.quantity = quantity;
//        this.sum = sum;
//
//    }
//
//
////    public Cartt(Long id, Long user_id, Long id_shop, Long id_product, Long quantity, Double sum) {
//        this.user_id = user_id
//
//        this.id_product = id_product;
//        this.id = id;
//        this.quantity = quantity;
//        this.sum = sum;
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Long quantity) {
//        this.quantity = quantity;
//    }
//
//    public Double getSum() {
//        return sum;
//    }
//
//    public void setSum(Double sum) {
//        this.sum = sum;
//    }
//
//    public Long getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Long user_id) {
//        this.user_id = user_id;
//    }
//
//    public Long getId_shop() {
//        return id_shop;
//    }
//
//    public void setId_shop(Long id_shop) {
//        this.id_shop = id_shop;
//    }
//
//    public Long getId_product() {
//        return id_product;
//    }
//
//    public void setId_product(Long id_product) {
//        this.id_product = id_product;
//    }
//}
