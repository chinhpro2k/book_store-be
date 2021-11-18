package com.laptrinhweb.shopkibe.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {

    @GetMapping("/account/profile")
    public String getBuyerProfile(){
         SecurityContextHolder.getContext().getAuthentication();
        return "buyer profile";
    }
    @GetMapping("/account/profile2")
    public String getBuyerProfile2(){
        return "buyer profile2";
    }
}
