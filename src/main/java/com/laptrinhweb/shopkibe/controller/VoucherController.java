package com.laptrinhweb.shopkibe.controller;


import com.laptrinhweb.shopkibe.dtos.VoucherDTO;
import com.laptrinhweb.shopkibe.entity.Product;
import com.laptrinhweb.shopkibe.entity.Voucher;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.repository.ProductRepository;
import com.laptrinhweb.shopkibe.repository.VoucherRepository;
import com.laptrinhweb.shopkibe.responses.VoucherResponse;
import com.laptrinhweb.shopkibe.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/voucher")
public class VoucherController {
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private VoucherService voucherService;

    @PostMapping("/create")
    public ApiResponse createVoucher(@RequestBody VoucherDTO voucherDTO){
       return voucherService.createVoucher(voucherDTO);
    }

    @GetMapping("")
    public VoucherResponse getAllVoucher(){
        return voucherService.getVouchers();
    }

    @DeleteMapping
    public ApiResponse deleteVoucher(@RequestBody VoucherDTO voucherDTO){
        return voucherService.deleteVoucher(voucherDTO);
    }

    @PostMapping("/update")
    public ApiResponse updateVoucher(@RequestBody VoucherDTO voucherDTO){
        return voucherService.updateVoucher(voucherDTO);
    }
}

