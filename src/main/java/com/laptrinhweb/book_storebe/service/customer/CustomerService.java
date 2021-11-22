package com.laptrinhweb.book_storebe.service.customer;

import com.laptrinhweb.book_storebe.dtos.AddressDTO;
import com.laptrinhweb.book_storebe.dtos.CustomerDto;
import com.laptrinhweb.book_storebe.entity.customer.Address;
import com.laptrinhweb.book_storebe.entity.customer.CustomerMember;
import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.customer.CustomerMemberRepository;
import com.laptrinhweb.book_storebe.repository.customer.CustomerNewRepository;
import com.laptrinhweb.book_storebe.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerNewRepository customerNewRepository;
    @Autowired
    private CustomerMemberRepository customerMemberRepository;


    public ApiResponse create(CustomerDto customerDto) {
        CustomerNew customerNew = new CustomerNew();
        customerNew.setName(customerDto.getName());
        customerNew.setUserName(customerDto.getUserName());
        customerNew.setPassword(customerDto.getPassword());
        customerNewRepository.save(customerNew);

        return new ApiResponse(0);
    }

    public CustomerResponse login(CustomerDto customerDto) {
        CustomerNew customerNew = customerNewRepository.getByUserName(customerDto.getUserName());
        CustomerMember customerMember = customerMemberRepository.getByUserName(customerDto.getUserName());
        CustomerDto customerDto1 =null;
        if (customerNew != null) {
            if (customerDto.getPassword().equals(customerNew.getPassword()) ) {
                customerDto1=new CustomerDto();
                customerDto1.setName(customerNew.getName());
                customerDto1.setSex(customerNew.getSex());
                customerDto1.setDate_of_birth(customerNew.getDate_of_birth());
                return new CustomerResponse(customerDto1,200);
            }else {

            }
        } else {
            if (customerMember != null) {
                if (customerDto.getPassword().equals(customerMember.getPassword()) ) {
                    customerDto1=new CustomerDto();
                    customerDto1.setName(customerMember.getName());
                    customerDto1.setSex(customerMember.getSex());
                    customerDto1.setDate_of_birth(customerMember.getDate_of_birth());
                    return new CustomerResponse(customerDto1,200);
                }
            }
        }
        return new CustomerResponse(customerDto1,400);
    }


    public void updateAdd(AddressDTO dto) {
        CustomerNew customerNew = customerNewRepository.findById(dto.getuId()).orElse(null);
        if (customerNew != null) {
            Address address = new Address();
            //set gia tri
            address.setCustomerNew(customerNew);
            //addrepo.save
        }
    }


}
