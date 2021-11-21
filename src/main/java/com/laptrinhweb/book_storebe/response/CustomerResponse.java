package com.laptrinhweb.book_storebe.response;

import com.laptrinhweb.book_storebe.dtos.CustomerDto;

public class CustomerResponse {
private CustomerDto customer;

    public CustomerResponse(CustomerDto customer) {
        this.customer = customer;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
