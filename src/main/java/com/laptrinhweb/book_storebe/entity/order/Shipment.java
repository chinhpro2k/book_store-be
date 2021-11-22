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
    private  Long order_id ;

    public Shipment(Long id, String address, String shipment, Long price,Long order_id) {
        this.id = id;
        this.address = address;
        this.shipment = shipment;
        this.price = price;
        this.order_id = order_id;
    }

    public Shipment(String address, String shipment, Long price,Long order_id) {
        this.address = address;
        this.shipment = shipment;
        this.price = price;
        this.order_id = order_id;
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

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
}
