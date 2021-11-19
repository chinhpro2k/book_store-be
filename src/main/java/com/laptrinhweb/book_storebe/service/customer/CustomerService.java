package com.laptrinhweb.book_storebe.service.customer;

import com.laptrinhweb.book_storebe.dtos.CustomerDto;
import com.laptrinhweb.book_storebe.entity.customer.Account;
import com.laptrinhweb.book_storebe.entity.customer.Customer;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.customer.AccountRepository;
import com.laptrinhweb.book_storebe.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;


    public ApiResponse create(CustomerDto customerDto){
        Customer customer=new Customer();
        Account account=new Account();
        account.setUserName(customerDto.getUserName());
        account.setPassword(customerDto.getPassword());
        customer.setName(customerDto.getName());
        customer.setSex(customerDto.getSex());
        customer.setDate_of_birth(customerDto.getDate_of_birth());
        customerRepository.save(customer);
        accountRepository.save(account);
        return new ApiResponse(0);
    }
}
