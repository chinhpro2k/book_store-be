//package com.laptrinhweb.shopkibe.controller;
//
//
//import com.laptrinhweb.shopkibe.entity.Cartt;
//import com.laptrinhweb.shopkibe.entity.Product;
//import com.laptrinhweb.shopkibe.entity.User;
//import com.laptrinhweb.shopkibe.payload.ApiResponse;
//import com.laptrinhweb.shopkibe.repository.CartRepository;
//import com.laptrinhweb.shopkibe.repository.CarttRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/cartt")
//public class CarttController {
//
//    @Autowired
//    private CarttRepository carttRepository;
//
//    @PostMapping("/create")
//    public ApiResponse createCart(@RequestBody Cartt cartReq){
////        System.out.println(cartReq);
////        Cartt cart = new Cart(cartReq.getShop() , cartReq.getImg(),cartReq.getProduct(),cartReq.getPrice(),cartReq.getQuantity(),cartReq.getUser_id());
////        carttRepository.save(cart);
////        return new ApiResponse(0);
//    }
//
//    @PostMapping("/update")
//    public ApiResponse updateCart(@RequestBody Cartt cartReq ){
//        carttRepository.updateCartQuantity(cartReq.getQuantity(),cartReq.getId());
//        return new ApiResponse(0) ;
//    }
//
//    @PostMapping ("/delete")
//    public ApiResponse deleteCart(@RequestBody Cartt cartReq){
//        carttRepository.deleteCart(cartReq.getId());
//        return new ApiResponse(0);
//    }
//
//    @PostMapping("")
//    public ArrayList<Cartt> getCart(@RequestBody User userReq , ){
//
//        return carttRepository.getCartById(userReq.getId()) ;
//    }
////    @DeleteMapping("/delete/{id}")
////    public ApiResponse deleteCart(@)
//
//
////    @GetMapping("")
////    public ArrayList<Cart> getAllCart(){
////        return cartRepository.getAllCart();
////    }
//
//
//}
//
//;