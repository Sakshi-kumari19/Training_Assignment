package com.example.orders.service;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.entity.OrderEntity;
import com.example.orders.exception.OrderNotFoundException;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repo;
    @Override
    public OrderEntity createOrder(OrderRequestDTO request) {
        OrderEntity order = new OrderEntity();
            order.setCustomerName(request.getCustomerName());
            order.setEmail(request.getEmail());
            order.setProductName(request.getProductName());
            order.setQuantity(request.getQuantity());
            order.setPricePerUnit(request.getPricePerUnit());
            order.setTotalAmount(request.getPricePerUnit() * request.getQuantity());

            return repo.save(order);

    }

    @Override
    public OrderEntity getOrderById(Long id) {
        Optional<OrderEntity> op = repo.findById(id);
        if(op.isPresent()){
            return op.get();
        }else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public void deleteOrder(Long id) {

        if(repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new OrderNotFoundException();
        }
    }
}
