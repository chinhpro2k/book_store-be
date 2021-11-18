package com.laptrinhweb.shopkibe.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String shop;
    private String img ;
    private String product ;
    private Double price ;
    private Long quantity ;
    private Double sum;
    @Column(name = "user_id")
    private Long user_id;


    public Cart(){}

    public Cart(String shop,String img , String product , Double price , Long quantity,Long user_id){
        this.shop = shop;
        this.img = img ;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.user_id = user_id;
    }
    public Cart(Long id,String shop,String img , String product , Double price , Long quantity,Double sum){
        this.id = id ;
        this.shop = shop;
        this.img = img ;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.sum = sum;
    }

    public Cart(Long id, String shop, String img, String product, Double price, Long quantity, Double sum, Long user_id) {

        this.id = id;
        this.shop = shop;
        this.img = img;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.sum = sum;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Long getQuantity() {
            return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}




