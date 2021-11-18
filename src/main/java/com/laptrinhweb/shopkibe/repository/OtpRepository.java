package com.laptrinhweb.shopkibe.repository;

import com.laptrinhweb.shopkibe.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {

    @Query("select o from Otp o where o.user_id = ?1")
    ArrayList<Otp> getOtpByUserId(Long userId);
}
