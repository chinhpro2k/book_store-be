package com.laptrinhweb.shopkibe.payload.auth;

public class OTPRequest {
    private String email;
    private Long otp;
    private Long id;
    private String shopName;
    private String shopAddress;

    public OTPRequest(String email, Long otp, Long id, String shopName, String shopAddress) {
        this.email = email;
        this.otp = otp;
        this.id = id;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getOtp() {
        return otp;
    }

    public void setOtp(Long otp) {
        this.otp = otp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
}
