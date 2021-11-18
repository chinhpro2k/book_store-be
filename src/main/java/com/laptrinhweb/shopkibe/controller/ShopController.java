package com.laptrinhweb.shopkibe.controller;

import com.laptrinhweb.shopkibe.dtos.ShopDTO;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.responses.ShopResponse;
import com.laptrinhweb.shopkibe.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping()
    public ShopResponse getShop(@RequestParam String id) {
        return shopService.getShop(id);
    }

    @PostMapping("/edit")
    public ApiResponse editShop(@RequestBody ShopDTO shopDTO) {
        return shopService.editShop(shopDTO);
    }

    @PutMapping("/active")
    public ApiResponse activeShop(@RequestBody ShopDTO shopDTO) {
        return shopService.activeShop(shopDTO);
    }

    @PutMapping("/unActive")
    public ApiResponse unActiveShop(@RequestBody ShopDTO shopDTO) {
        return shopService.unActiveShop(shopDTO);
    }
}
