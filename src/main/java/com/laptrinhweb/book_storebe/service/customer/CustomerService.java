package com.laptrinhweb.book_storebe.service.customer;

import com.laptrinhweb.book_storebe.dtos.AddressDTO;
import com.laptrinhweb.book_storebe.dtos.CustomerDto;
import com.laptrinhweb.book_storebe.entity.customer.Address;
import com.laptrinhweb.book_storebe.entity.customer.CustomerMember;
import com.laptrinhweb.book_storebe.entity.customer.CustomerNew;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.customer.AddressRepository;
import com.laptrinhweb.book_storebe.repository.customer.CustomerMemberRepository;
import com.laptrinhweb.book_storebe.repository.customer.CustomerNewRepository;
import com.laptrinhweb.book_storebe.response.AddressResponse;
import com.laptrinhweb.book_storebe.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerNewRepository customerNewRepository;
    @Autowired
    private CustomerMemberRepository customerMemberRepository;
    @Autowired
    private AddressRepository addressRepository;


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
                customerDto1.setCustomerId(customerNew.getId());
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
                    customerDto1.setCustomerId(customerMember.getId());
                    customerDto1.setName(customerMember.getName());
                    customerDto1.setSex(customerMember.getSex());
                    customerDto1.setDate_of_birth(customerMember.getDate_of_birth());
                    return new CustomerResponse(customerDto1,200);
                }
            }
        }
        return new CustomerResponse(customerDto1,400);
    }


    public ApiResponse updateAdd(AddressDTO addressDTO) {
        CustomerNew customerNew = customerNewRepository.findById(addressDTO.getuId()).orElse(null);
        if (customerNew != null) {
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setDistrict(addressDTO.getDistrict());
            address.setNumber(addressDTO.getNumber());
            address.setStreet(addressDTO.getStreet());
            address.setNumberphone(addressDTO.getNumberphone());
            address.setCustomerNew(customerNew);
            addressRepository.save(address);
            return new ApiResponse(0);
        }
        return new ApiResponse(1);
    }

    public AddressResponse getListAddress(String uId){
        List<Address> addresses=addressRepository.getListAddress(Long.parseLong(uId));
        List<AddressDTO> addressDTOS=new ArrayList<>();
        for (Address address:addresses){
            AddressDTO addressDTO=new AddressDTO();
            addressDTO.setId(address.getId());
            addressDTO.setNumber(address.getNumber());
            addressDTO.setStreet(address.getStreet());
            addressDTO.setDistrict(address.getDistrict());
            addressDTO.setCity(address.getCity());
            addressDTO.setNumberphone(address.getNumberphone());
            addressDTOS.add(addressDTO);
        }
        return new AddressResponse(addressDTOS);
    }

    public CustomerResponse getCustomer(CustomerDto customerDto){
        CustomerNew customerNew=customerNewRepository.findByUserId(customerDto.getCustomerId());
        if (customerNew!=null){
            CustomerDto customerDto1=new CustomerDto();
            customerDto1.setName(customerNew.getName());
            customerDto1.setDate_of_birth(customerNew.getDate_of_birth());
            customerDto1.setSex(customerNew.getSex());
            customerDto1.setEmail(customerNew.getEmail());
            customerDto1.setNumberphone(customerNew.getNumberphone());
            return new CustomerResponse(customerDto1,200);
        }
       return new CustomerResponse(null,400);
    }
    public ApiResponse updateCustomer(CustomerDto customerDto){
        CustomerNew customerNew =customerNewRepository.findByUserId(customerDto.getCustomerId());
        customerNew.setEmail(customerDto.getEmail());
        customerNew.setNumberphone(customerDto.getNumberphone());
        customerNew.setSex(customerDto.getSex());
        customerNew.setDate_of_birth(customerDto.getDate_of_birth());
        customerNewRepository.save(customerNew);
        return new ApiResponse(0);
    }
}
