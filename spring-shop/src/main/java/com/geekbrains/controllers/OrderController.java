package com.geekbrains.controllers;

import com.geekbrains.aspect.Log;
import com.geekbrains.entities.Order;
import com.geekbrains.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Log(message = "#dto.example")
    @GetMapping
    public List<Order> findAllOrders(/*@RequestBody InputDTO dto*/) {
        System.out.println("Зашли в лог через контроллер");
        List<Order> orders = orderRepository.findAll();

        return orders;
    }

}
