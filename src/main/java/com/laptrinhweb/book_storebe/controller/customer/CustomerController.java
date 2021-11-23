package com.laptrinhweb.book_storebe.controller.customer;

import com.laptrinhweb.book_storebe.dtos.AddressDTO;
import com.laptrinhweb.book_storebe.dtos.CustomerDto;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.response.AddressResponse;
import com.laptrinhweb.book_storebe.response.CustomerResponse;
import com.laptrinhweb.book_storebe.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/create")
    public ApiResponse create(@RequestBody CustomerDto customerDto){
        return customerService.create(customerDto);
    }

    @PostMapping("/login")
    public CustomerResponse login(@RequestBody CustomerDto customerDto){
        return customerService.login(customerDto);
    }

    @PostMapping("/change/address")
    public ApiResponse update(@RequestBody AddressDTO addressDTO){
        return customerService.updateAdd(addressDTO);
    }

    @GetMapping("/address")
    public AddressResponse getListAddress(@RequestParam String id){
        return customerService.getListAddress(id);
    }

    @PostMapping("/getById")
    public CustomerResponse getById(@RequestBody CustomerDto customerDto){
    return customerService.getCustomer(customerDto);
    }
}
