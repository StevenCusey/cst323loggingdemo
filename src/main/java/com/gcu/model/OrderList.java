package com.gcu.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "orders")
public class OrderList {

    private List<OrderModel> orders = new ArrayList<>();

    // JAXB requires a getter and setter for serialization and deserialization

    @XmlElement(name = "order")
    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
