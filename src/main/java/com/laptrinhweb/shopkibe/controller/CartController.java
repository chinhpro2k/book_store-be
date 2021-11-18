package com.laptrinhweb.shopkibe.controller;
import com.laptrinhweb.shopkibe.entity.Cart;

import com.laptrinhweb.shopkibe.entity.User;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/create")
    public ApiResponse createCart(@RequestBody Cart cartReq){
        System.out.println(cartReq);
        Cart cart = new Cart(cartReq.getShop() , cartReq.getImg(),cartReq.getProduct(),cartReq.getPrice(),cartReq.getQuantity(),cartReq.getUser_id());
        cartRepository.save(cart);
        return new ApiResponse(0);
    }

    @PostMapping("/update")
    public ApiResponse updateCart(@RequestBody Cart cartReq ){
        cartRepository.updateCartQuantity(cartReq.getQuantity(),cartReq.getId());
        return new ApiResponse(0) ;
    }

    @PostMapping ("/delete")
    public ApiResponse deleteCart(@RequestBody Cart cartReq){
        cartRepository.deleteCart(cartReq.getId());
        return new ApiResponse(0);
    }

    @PostMapping("")
    public ArrayList<Cart> getCart(@RequestBody User userReq){

        return cartRepository.getCartById(userReq.getId()) ;
    }
//    @DeleteMapping("/delete/{id}")
//    public ApiResponse deleteCart(@)


//    @GetMapping("")
//    public ArrayList<Cart> getAllCart(){
//        return cartRepository.getAllCart();
//    }


}

;