package com.gcu.business;

import com.gcu.model.OrderModel;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;


public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {

    @Override
    public void test() {
        System.out.println("Hello from AnotherOrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        
        return Arrays.asList(
            new OrderModel("5L", "000000006", "Product 6", 6.00f, 1),
            new OrderModel("6L", "000000007", "Product 7", 7.00f, 2),
            new OrderModel("6L", "000000008", "Product 8", 7.00f, 3),
            new OrderModel("6L", "000000009", "Product 9", 7.00f, 4),
            new OrderModel("6L", "0000000010", "Product 10", 7.00f, 5)
            
        );
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
