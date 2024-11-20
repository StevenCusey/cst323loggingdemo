package com.gcu.business;

import com.gcu.model.OrderModel;
import java.util.List;

public interface OrdersBusinessServiceInterface {
    void test();
    List<OrderModel> getOrders();
    void init();
    void destroy();
}
