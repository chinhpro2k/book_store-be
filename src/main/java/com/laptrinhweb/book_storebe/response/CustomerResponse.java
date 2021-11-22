package com.laptrinhweb.book_storebe.response;

import com.laptrinhweb.book_storebe.dtos.CustomerDto;

public class CustomerResponse {
private CustomerDto customer;
private int status;
    public CustomerResponse(CustomerDto customer,int status) {
        this.customer = customer;
        this.status=status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }



    




}
