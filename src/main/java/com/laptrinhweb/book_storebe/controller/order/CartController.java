package com.laptrinhweb.book_storebe.controller.order;

import com.laptrinhweb.book_storebe.dtos.CartDetailDto;
import com.laptrinhweb.book_storebe.dtos.CartDto;
import com.laptrinhweb.book_storebe.dtos.GetCartDto;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.service.order.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/save")
    public ApiResponse create(@RequestBody CartDto cartDto) {
        return cartService.update(cartDto);
    }
    @PostMapping("/get-carts")
    public List<CartDetailDto> getCarts(@RequestBody GetCartDto getCartDto) {
        return cartService.getCart(getCartDto);
    }
}
