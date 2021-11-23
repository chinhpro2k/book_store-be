package com.laptrinhweb.book_storebe.controller;
import com.laptrinhweb.book_storebe.dtos.CustomerDto;
import com.laptrinhweb.book_storebe.entity.order.Shipment;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.repository.ShipmentRepository;
import com.laptrinhweb.book_storebe.response.CustomerResponse;
import com.laptrinhweb.book_storebe.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/shipment1")

public class ShipmentController {
    @Autowired ShipmentRepository shipmentRepository;




    @PostMapping("/create")
    public ApiResponse createShipment(@RequestBody Shipment sReq) {
        System.out.println(sReq);
        Shipment s = new Shipment(sReq.getShipment(),sReq.getAddress(), sReq.getPrice());
        shipmentRepository.save(s);
        return new ApiResponse(0);
    }

    @GetMapping()
    public String hello(){
        return "hello";
    }




}
