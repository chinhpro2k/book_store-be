package com.laptrinhweb.book_storebe.entity.information;
import javax.persistence.*;

@Entity
@Table(name = "address")

public class Address {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name ;
    private Long phone ;
    private String city;
    private String district ;
    private String street ;
    private Long number ;
    private Long user_id ;

    public Address(){}

    public Address(Long id, String name, Long phone, String city,String district,String street,Long number, Long user_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.district = district;
        this.street = street ;
        this.number = number;
        this.user_id = user_id;
    }

    public Address(String name, Long phone, String city,String district,String street,Long number, Long user_id) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.district=district;
        this.street = street;
        this.number = number;

        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}


