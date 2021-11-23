package com.laptrinhweb.book_storebe.controller.order;

import com.laptrinhweb.book_storebe.dtos.CartDetailDto;
import com.laptrinhweb.book_storebe.dtos.GetCartDto;
import com.laptrinhweb.book_storebe.dtos.OrderDto;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public ApiResponse create(@RequestBody OrderDto oderDto) {
        return orderService.createOrder(oderDto);
    }
}
