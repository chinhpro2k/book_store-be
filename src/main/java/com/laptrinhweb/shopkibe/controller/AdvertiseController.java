package com.laptrinhweb.shopkibe.controller;


import com.laptrinhweb.shopkibe.entity.Advertise;
import com.laptrinhweb.shopkibe.entity.Cart;
import com.laptrinhweb.shopkibe.entity.User;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.repository.AdvertiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/advertise")
public class AdvertiseController {
    @Autowired
    private AdvertiseRepository advertiseRepository;

    @PostMapping("/create")
    public ApiResponse createAdvertise(@RequestBody Advertise advertiseReq){
        System.out.println(advertiseReq);
        Advertise advertise = new Advertise(advertiseReq.getImg(),advertiseReq.getName(), advertiseReq.getDescription(),advertiseReq.getUser_id());
        advertiseRepository.save(advertise);
        return new ApiResponse(0);
    }
    @PostMapping("")
    public ArrayList<Advertise> getAdvertise(@RequestBody User userReq){

        return advertiseRepository.getAdvertiseById(userReq.getId()) ;
    }
}


