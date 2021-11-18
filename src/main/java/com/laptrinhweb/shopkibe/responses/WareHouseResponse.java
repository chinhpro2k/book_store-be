package com.laptrinhweb.shopkibe.responses;

import com.laptrinhweb.shopkibe.dtos.WareHouseDTO;

import java.util.List;

public class WareHouseResponse {
    public List<WareHouseDTO> getWareHouses() {
        return warehouses;
    }

    public WareHouseResponse(WareHouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public WareHouseResponse(List<WareHouseDTO> wareHouses) {
        this.warehouses = wareHouses;
    }

    public void setWareHouses(List<WareHouseDTO> wareHouses) {
        this.warehouses = wareHouses;
    }

    private List<WareHouseDTO> warehouses;

    public WareHouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WareHouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    private WareHouseDTO warehouse;

}
