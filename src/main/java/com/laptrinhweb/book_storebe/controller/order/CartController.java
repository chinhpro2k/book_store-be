package com.laptrinhweb.book_storebe.controller.order;

import com.laptrinhweb.book_storebe.dtos.CartDto;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.service.order.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/save")
    public ApiResponse create(@RequestBody CartDto cartDto) {
        return cartService.update(cartDto);
    }

}
