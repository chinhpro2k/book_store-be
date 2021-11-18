package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.dtos.ProductDTO;
import com.laptrinhweb.shopkibe.dtos.WareHouseDTO;
import com.laptrinhweb.shopkibe.entity.Product;
import com.laptrinhweb.shopkibe.entity.WareHouse;
import com.laptrinhweb.shopkibe.payload.ApiResponse;
import com.laptrinhweb.shopkibe.repository.ProductRepository;
import com.laptrinhweb.shopkibe.repository.WareHouseRepository;
import com.laptrinhweb.shopkibe.responses.ProductResponse;
import com.laptrinhweb.shopkibe.responses.WareHouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WareHouseService {

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Autowired
    private ProductRepository productRepository;

    public ApiResponse create(WareHouseDTO wareHouseDTO) {
        WareHouse wareHouse = new WareHouse();
        wareHouse.setAddress(wareHouseDTO.getAddress());
        wareHouse.setShop_id(wareHouseDTO.getShop_id());
        wareHouse.setName(wareHouseDTO.getName());
        wareHouse.setImage_url(wareHouseDTO.getImage_url());
        wareHouseRepository.save(wareHouse);
        return new ApiResponse(0);
    }

    public WareHouseResponse getWarehouses() {
        List<WareHouse> wareHouses = wareHouseRepository.getAllWarehouse();
        List<WareHouseDTO> wareHouseDTOS = new ArrayList<>();
        for (WareHouse wareHouse : wareHouses) {
            WareHouseDTO wareHouseDTO = new WareHouseDTO();
            wareHouseDTO.setId(wareHouse.getId());
            wareHouseDTO.setName(wareHouse.getName());
            wareHouseDTO.setAddress(wareHouse.getAddress());
            wareHouseDTO.setShop_id(wareHouse.getShop_id());
            wareHouseDTO.setImage_url(wareHouse.getImage_url());
            wareHouseDTOS.add(wareHouseDTO);
        }
        return new WareHouseResponse(wareHouseDTOS);
    }
    public ApiResponse update(WareHouseDTO wareHouseDTO){
        WareHouse wareHouse = wareHouseRepository.getById(wareHouseDTO.getId());
        if (Objects.isNull(wareHouse)) {
            return new ApiResponse(1, "not find warehouse!");
        } else {
            wareHouse.setName(wareHouseDTO.getName());
            wareHouse.setAddress(wareHouseDTO.getAddress());
            wareHouseRepository.save(wareHouse);
            return new ApiResponse(0);
        }

    }

    public ApiResponse delete(WareHouseDTO wareHouseDTO) {
        WareHouse wareHouse = wareHouseRepository.getById(wareHouseDTO.getId());
        if (Objects.isNull(wareHouse)) {
            return new ApiResponse(1, "not find warehouse!");
        } else {
            if (mapProductWarehouse(wareHouseDTO.getId().toString()).isEmpty()){
                wareHouseRepository.delete(wareHouse);
                return new ApiResponse(0);

            }else{
                return new ApiResponse(1,"kho van con san pham");
            }

        }

    }

    public ApiResponse createProduct(ProductDTO productDTO){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setShop_id(productDTO.getShopId());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());
        product.setWarehouse_id(productDTO.getWarehouse_id());
        product.setExport(false);

        productRepository.save(product);

        return new ApiResponse(0);
    }

    public WareHouseResponse getWarehouse(String id){
        WareHouse wareHouse=wareHouseRepository.getById(Long.parseLong(id));
        WareHouseDTO wareHouseDTO=new WareHouseDTO();
        wareHouseDTO.setId(wareHouse.getId());
        wareHouseDTO.setName(wareHouse.getName());
        wareHouseDTO.setAddress(wareHouse.getAddress());
        wareHouseDTO.setImage_url(wareHouse.getImage_url());
        wareHouseDTO.setShop_id(wareHouse.getShop_id());
        wareHouseDTO.setProducts(mapProductWarehouse(id));
        return new WareHouseResponse(wareHouseDTO);
    }

    public ApiResponse exportProduct(ProductDTO productDTO){
        Product product=productRepository.getById(productDTO.getId());
        product.setExport(true);
        productRepository.save(product);
        return new ApiResponse(0);
    }

    protected List<Product> mapProductWarehouse(String id){
        List<Product> products=productRepository.getProductInWarehouse(Long.parseLong(id));
        return products;
    }


//    public ProductResponse getProductsWarehouse(String id){
//
//
//    }
}
