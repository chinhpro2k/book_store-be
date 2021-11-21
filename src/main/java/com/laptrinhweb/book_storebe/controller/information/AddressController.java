package com.laptrinhweb.book_storebe.controller.information;


import com.laptrinhweb.book_storebe.entity.customer.Account;
import com.laptrinhweb.book_storebe.entity.information.Address;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.Information.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/create")
    public ApiResponse createAddress(@RequestBody Address addressReq){
        System.out.println(addressReq);
        Address addressUser = new Address(addressReq.getName(),addressReq.getPhone(), addressReq.getCity(),addressReq.getDistrict(),addressReq.getStreet(),addressReq.getNumber(), addressReq.getUser_id());
        addressRepository.save(addressUser)      ;
        return new ApiResponse(0);
    }

    @PostMapping("/update")
    public ApiResponse updateAddress(@RequestBody Address address ){
        addressRepository.updateAddress(address.getPhone(),address.getId());
        return new ApiResponse(0) ;
    }
    @PostMapping ("/delete")
    public ApiResponse deleteAddress(@RequestBody Address addressReq){
        addressRepository.deleteAddress(addressReq.getId());
        return new ApiResponse(0);
    }

    @PostMapping ("")
    public ArrayList<Address> getAddress(@RequestBody Account userReq){

        return addressRepository.getAddress(userReq.getId()) ;
    }
}
