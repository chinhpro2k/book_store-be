package com.laptrinhweb.book_storebe.dtos;

import lombok.Data;

@Data
public class OrderDto {
    private Long CartId;
    private Long ShipmentId;
    private int status;
    private Long CustomerId;
}
