package com.laptrinhweb.book_storebe.dtos;

public class CartDto {
    private float totalPrice;
    private float quantity;
    private Long bookItemId;
    private Long userId;
    private int status;

    public CartDto(float totalPrice, float quantity, Long bookItemId, Long userId, int status) {
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.bookItemId = bookItemId;
        this.userId = userId;
        this.status = status;
    }

    public Long getBookItemId() {
        return bookItemId;
    }

    public void setBookItemId(Long bookItemId) {
        this.bookItemId = bookItemId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

}
