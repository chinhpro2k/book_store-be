package com.laptrinhweb.shopkibe.repository;


import com.laptrinhweb.shopkibe.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher,Long>
{
    @Query("select  v from Voucher v")
    ArrayList<Voucher>getAllVoucher();
}
