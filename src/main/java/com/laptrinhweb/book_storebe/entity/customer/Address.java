package com.laptrinhweb.book_storebe.entity.customer;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long number;
    private String city;
    private String district;
    private String street;
    private String numberphone;

    @ManyToOne
    @JoinColumn(name = "customer_member_id")
    private CustomerMember customerMember;

    public CustomerMember getCustomerMember() {
        return customerMember;
    }

    public void setCustomerMember(CustomerMember customerMember) {
        this.customerMember = customerMember;
    }

    @ManyToOne
    @JoinColumn(name = "customer_new_id")
    private CustomerNew customerNew;

    public CustomerNew getCustomerNew() {
        return customerNew;
    }

    public void setCustomerNew(CustomerNew customerNew) {
        this.customerNew = customerNew;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }
}
