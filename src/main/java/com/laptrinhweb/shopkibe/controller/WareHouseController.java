package com.laptrinhweb.shopkibe.controller;

import com.laptrinhweb.shopkibe.dtos.ProductDTO;
import com.laptrinhweb.shopkibe.dtos.WareHouseDTO;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.responses.WareHouseResponse;
import com.laptrinhweb.shopkibe.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;

    @GetMapping()
    public WareHouseResponse getWareHouse(){
        return wareHouseService.getWarehouses();
    }

    @PostMapping("/create")
    public ApiResponse createWareHouse(@RequestBody WareHouseDTO wareHouseDTO){
        return wareHouseService.create(wareHouseDTO);
    }
    @PostMapping("/edit")
    public ApiResponse editWarehouse(@RequestBody WareHouseDTO wareHouseDTO){
        return wareHouseService.update(wareHouseDTO);
    }

    @DeleteMapping()
    public ApiResponse deleteWarehouse(@RequestBody WareHouseDTO wareHouseDTO){
        return wareHouseService.delete(wareHouseDTO);
    }

    @PostMapping("/product/create")
    public ApiResponse createProduct(@RequestBody ProductDTO productDTO){
        return wareHouseService.createProduct(productDTO);
    }

    @GetMapping("/detail")
    public WareHouseResponse getDetailWarehouse(@RequestParam String id){
        return wareHouseService.getWarehouse(id);
    }

    @PostMapping("export")
    public ApiResponse exportProduct(@RequestBody ProductDTO productDTO){
        return wareHouseService.exportProduct(productDTO);
    }

}
