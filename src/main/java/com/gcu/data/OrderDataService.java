package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;


@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {

    @Autowired
    private OrdersRepository ordersRepository;

    /**
     * Non-Default constructor for constructor injection.
     */
    public OrderDataService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    /**
     * CRUD: finder to return a single entity
     */
    @Override
    public OrderEntity findById(int id) {
        // For now, return null
        return null;
    }

    /**
     * CRUD: finder to return all entities
     */
    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = new ArrayList<>();
        try {
            // Get all the Entity Orders
            Iterable<OrderEntity> orderIterable = ordersRepository.findAll();

            // Convert to a List and return the List
            orderIterable.forEach(orders::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return the List
        return orders;
    }

    /**
     * CRUD: create an entity
     */
    @Override
    public boolean create(OrderEntity order) {
        try {
            ordersRepository.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * CRUD: update an entity
     */
    @Override
    public boolean update(OrderEntity order) {
        // For now, just return true
        return true;
    }

    /**
     * CRUD: delete an entity
     */
    @Override
    public boolean delete(OrderEntity order) {
        // For now, just return true
        return true;
    }
}
