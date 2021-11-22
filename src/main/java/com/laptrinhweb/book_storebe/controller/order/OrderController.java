package com.laptrinhweb.book_storebe.controller.order;

import com.laptrinhweb.book_storebe.dtos.OrderDto;
import com.laptrinhweb.book_storebe.payload.ApiResponse;
import com.laptrinhweb.book_storebe.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
