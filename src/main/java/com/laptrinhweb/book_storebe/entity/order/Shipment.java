package com.laptrinhweb.book_storebe.entity.order;

import javax.persistence.*;

@Entity
@Table(name="shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String address;
    private String shipment ;
    private Long price ;


    public Shipment(Long id, String address, String shipment, Long price) {
        this.id = id;
        this.address = address;
        this.shipment = shipment;
        this.price = price;

    }

    public Shipment(String address, String shipment, Long price) {
        this.address = address;
        this.shipment = shipment;
        this.price = price;

    }

    public Shipment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

   
}
