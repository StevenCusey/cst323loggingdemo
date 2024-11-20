package com.gcu.business;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    @Autowired
    private OrderDataService service;

    @Override
    public void test() {
        System.out.println("Hello from OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        // Call the findAll() method on the service class-scoped variable and save the return value in a variable ordersEntity
        List<OrderEntity> ordersEntity = service.findAll();

        // Create an empty List<OrderModel> in a variable named ordersDomain
        List<OrderModel> ordersDomain = new ArrayList<>();

        // Iterate over the ordersEntity List and create a new instance of OrderModel
        // from the OrderEntity objects and add the instances of the OrderModel to the ordersDomain List
        for (OrderEntity entity : ordersEntity) {
            ordersDomain.add(new OrderModel(
                entity.getId(),
                entity.getOrderNo(),
                entity.getProductName(),
                entity.getPrice(),
                entity.getQuantity()
            ));
        }

        // Return the ordersDomain List
        return ordersDomain;
    }

    @Override
    public void init() {
        System.out.println("Initializing");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying");
    }
}
