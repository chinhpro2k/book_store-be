package com.laptrinhweb.book_storebe.response;

import com.laptrinhweb.book_storebe.dtos.AddressDTO;

import java.util.List;

public class AddressResponse {
    public AddressResponse(List<AddressDTO> address) {
        this.address = address;
    }

    private List<AddressDTO> address;

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }
}
