package com.laptrinhweb.book_storebe.dtos;

public class GetCartDto {
    private Long CustomerId;

    public GetCartDto() {
    }

    public GetCartDto(Long customerId) {
        CustomerId = customerId;
    }

    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long customerId) {
        CustomerId = customerId;
    }
}
