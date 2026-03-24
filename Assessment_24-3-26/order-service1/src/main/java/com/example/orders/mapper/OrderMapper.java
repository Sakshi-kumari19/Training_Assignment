package com.example.orders.mapper;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.dto.OrderResponseDTO;
import com.example.orders.entity.OrderEntity;

public class OrderMapper {

    public static OrderEntity toEntity(OrderRequestDTO dto) {
        OrderEntity e = new OrderEntity();
        return e;
    }

    public static OrderResponseDTO toResponseDTO(OrderEntity entity) {
        OrderResponseDTO dto = new OrderResponseDTO();
        return dto;
    }
}
