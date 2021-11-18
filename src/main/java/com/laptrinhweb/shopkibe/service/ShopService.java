package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.dtos.ShopDTO;
import com.laptrinhweb.shopkibe.entity.Shop;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.repository.ShopRepository;
import com.laptrinhweb.shopkibe.responses.ShopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;


    public ShopResponse getShop(String id) {
        Shop shop = shopRepository.getById(Long.parseLong(id));
        ShopDTO shopDTOs = new ShopDTO();
        shopDTOs.setId(shop.getId());
        shopDTOs.setName(shop.getName());
        shopDTOs.setAddress(shop.getAddress());
        shopDTOs.setImg(shop.getImg());
        shopDTOs.setActive(shop.getActive());
        return new ShopResponse(shopDTOs);
    }

    public ApiResponse editShop(ShopDTO shopDTO) {
        Shop shop = shopRepository.getById(shopDTO.getId());
        shop.setAddress(shopDTO.getAddress());
        shop.setImg(shopDTO.getImg());
        shop.setName(shopDTO.getName());
        shopRepository.save(shop);
        return new ApiResponse(0);
    }

    public ApiResponse activeShop(ShopDTO shopDTO) {
        Shop shop = shopRepository.getById(shopDTO.getId());
        if (shop != null) {
            shop.setActive(false);
            shopRepository.save(shop);
            return new ApiResponse(0);
        } else return new ApiResponse(1);
    }

    public ApiResponse unActiveShop(ShopDTO shopDTO) {
        Shop shop = shopRepository.getById(shopDTO.getId());
        if (shop != null) {
            shop.setActive(true);
            shopRepository.save(shop);
            return new ApiResponse(0);
        } else return new ApiResponse(1);
    }
}
