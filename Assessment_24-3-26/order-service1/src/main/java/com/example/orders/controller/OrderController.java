package com.example.orders.controller;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.dto.OrderResponseDTO;
import com.example.orders.entity.OrderEntity;
import com.example.orders.exception.OrderNotFoundException;
import com.example.orders.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")

public class OrderController {


    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@Valid @RequestBody OrderRequestDTO request) {
       OrderEntity o =  service.createOrder(request);
       OrderResponseDTO responseDTO = new OrderResponseDTO(o.getId(),o.getCustomerName(),o.getEmail(),o.getProductName(),o.getQuantity(),o.getPricePerUnit(),o.getTotalAmount());

       return new ResponseEntity<OrderResponseDTO>(responseDTO,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getById(@PathVariable Long id) {
        OrderEntity o = service.getOrderById(id);

        OrderResponseDTO responseDTO = new OrderResponseDTO(o.getId(),o.getCustomerName(),o.getEmail(),o.getProductName(),o.getQuantity(),o.getPricePerUnit(),o.getTotalAmount());
        return new ResponseEntity<OrderResponseDTO>(responseDTO,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

            service.deleteOrder(id);
            return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);

    }
}
