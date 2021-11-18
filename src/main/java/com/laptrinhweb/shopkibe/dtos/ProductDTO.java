package com.laptrinhweb.shopkibe.dtos;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Long shopId;
    private Long price;
    private ShopDTO shop;

    private String imageUrl;
    private Long warehouse_id;
    private WareHouseDTO warehouse;

    private Boolean isExport;

    public Boolean getExport() {
        return isExport;
    }

    public void setExport(Boolean export) {
        isExport = export;
    }

    public WareHouseDTO getWareHouse() {
        return warehouse;
    }

    public void setWareHouse(WareHouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
