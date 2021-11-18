package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.dtos.VoucherDTO;
import com.laptrinhweb.shopkibe.entity.Voucher;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.repository.VoucherRepository;
import com.laptrinhweb.shopkibe.responses.VoucherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public ApiResponse createVoucher(VoucherDTO voucherDTO){
        Voucher voucher= new Voucher(voucherDTO.getImg(),voucherDTO.getName(),voucherDTO.getDescription());
        voucherRepository.save(voucher);
        return new ApiResponse(0);
    }

    public ApiResponse deleteVoucher(VoucherDTO voucherDTO){
        Voucher voucher=voucherRepository.getById(voucherDTO.getId());
        if (voucher!=null){
            voucherRepository.delete(voucher);
            return new ApiResponse(0);
        }else return new ApiResponse(1);
    }


    public ApiResponse updateVoucher(VoucherDTO voucherDTO){
        Voucher voucher=voucherRepository.getById(voucherDTO.getId());
        if (voucher!=null){
            voucher.setName(voucherDTO.getName());
            voucher.setImg(voucherDTO.getImg());
            voucher.setDescription(voucherDTO.getDescription());
            voucherRepository.save(voucher);
            return new ApiResponse(0);
        }else return new ApiResponse(1);
    }

    public VoucherResponse getVouchers(){
        List<Voucher> vouchers=voucherRepository.getAllVoucher();
        return new VoucherResponse(vouchers);
    }
}
