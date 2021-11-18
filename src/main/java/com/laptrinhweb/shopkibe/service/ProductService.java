package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.dtos.ProductDTO;
import com.laptrinhweb.shopkibe.dtos.ShopDTO;
import com.laptrinhweb.shopkibe.dtos.WareHouseDTO;
import com.laptrinhweb.shopkibe.entity.Product;
import com.laptrinhweb.shopkibe.entity.Shop;
import com.laptrinhweb.shopkibe.entity.WareHouse;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.repository.ProductRepository;
import com.laptrinhweb.shopkibe.repository.ShopRepository;
import com.laptrinhweb.shopkibe.repository.WareHouseRepository;
import com.laptrinhweb.shopkibe.responses.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private WareHouseRepository wareHouseRepository;

    public ProductResponse getProducts() {
        List<Product> products = productRepository.getAllProduct();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setShop(mapShopData(product));
            productDTO.setId(product.getId());
            productDTO.setShopId(product.getShop_id());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setImageUrl(product.getImageUrl());
            productDTO.setDescription(product.getDescription());
            productDTO.setWarehouse_id(product.getWarehouse_id());
            productDTO.setWareHouse(mapWareData(product));
            productDTO.setExport(product.getExport());
            productDTOS.add(productDTO);
        }
        return new ProductResponse(productDTOS);
    }

    public ProductResponse getProduct(ProductDTO productDTO) {
        Product product = productRepository.getById(productDTO.getId());
        ProductDTO productDTOs = new ProductDTO();
        productDTOs.setShop(mapShopData(product));
        productDTOs.setId(product.getId());
        productDTOs.setShopId(product.getShop_id());
        productDTOs.setName(product.getName());
        productDTOs.setPrice(product.getPrice());
        productDTOs.setImageUrl(product.getImageUrl());
        productDTOs.setDescription(product.getDescription());
        return new ProductResponse(productDTOs);

    }

    public ApiResponse create(ProductDTO productDTO) {
        Product product = new Product();
        product.setShop_id(productDTO.getShopId());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());
        product.setExport(true);
        productRepository.save(product);
        return new ApiResponse(0);
    }

    public ApiResponse update(ProductDTO productDTO) {
        Product product = productRepository.getById(productDTO.getId());
        product.setShop_id(productDTO.getShopId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
        return new ApiResponse(0);
    }

    public ApiResponse delete(ProductDTO productDTO) {
        ApiResponse response = new ApiResponse();
        Product product = productRepository.getById(productDTO.getId());
        if (Objects.isNull(product)) {
            response.setMsg("Khong tim thay san pham nay!");
        } else {
            productRepository.delete(product);
        }
        return response;
    }

    protected ShopDTO mapShopData(Product product) {
        ShopDTO shopDTO = null;
        if (product.getShop_id() != null) {
            Shop shop = shopRepository.getById(product.getShop_id());
            if (shop != null) {
                shopDTO = new ShopDTO();
                shopDTO.setAddress(shop.getAddress());
                shopDTO.setImg(shop.getImg());
                shopDTO.setUser_id(shop.getUser_id());
                shopDTO.setId(shop.getId());
                shopDTO.setName(shop.getName());
            }
        }
        return shopDTO;
    }

    protected WareHouseDTO mapWareData(Product product) {
        WareHouseDTO wareHouseDTO = null;
        if (product.getWarehouse_id() != null) {
            WareHouse wareHouse = wareHouseRepository.getById(product.getWarehouse_id());
            if (wareHouse != null) {
                wareHouseDTO = new WareHouseDTO();
                wareHouseDTO.setName(wareHouse.getName());
            }

        }
        return wareHouseDTO;

    }
}
