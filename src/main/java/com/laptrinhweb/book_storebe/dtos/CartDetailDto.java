package com.laptrinhweb.book_storebe.dtos;

public class CartDetailDto {
    private Long Id;
    private Long BookItemId;
    private Float Quantity;
    private double Price;
    private String title,img,summary;

    public CartDetailDto() {
    }

    public CartDetailDto(Long id, Long bookItemId, Float quantity, double price, String title, String img, String summary) {
        Id = id;
        BookItemId = bookItemId;
        Quantity = quantity;
        Price = price;
        this.title = title;
        this.img = img;
        this.summary = summary;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getBookItemId() {
        return BookItemId;
    }

    public void setBookItemId(Long bookItemId) {
        BookItemId = bookItemId;
    }

    public Float getQuantity() {
        return Quantity;
    }

    public void setQuantity(Float quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
