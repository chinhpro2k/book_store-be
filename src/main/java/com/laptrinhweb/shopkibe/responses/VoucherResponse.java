package com.laptrinhweb.shopkibe.responses;

import com.laptrinhweb.shopkibe.entity.Voucher;

import java.util.List;

public class VoucherResponse {
    public VoucherResponse(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    List<Voucher> vouchers;

}
