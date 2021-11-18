package com.laptrinhweb.shopkibe.responses;

import com.laptrinhweb.shopkibe.dtos.ShopDTO;

public class ShopResponse {
    private ShopDTO shop;

    public ShopResponse(ShopDTO shop) {
        this.shop = shop;
    }

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }
}
