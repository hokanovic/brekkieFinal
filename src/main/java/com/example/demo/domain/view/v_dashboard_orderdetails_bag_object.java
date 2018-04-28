package com.example.demo.domain.view;

import com.example.demo.domain.OrderBagProducts;
import com.example.demo.domain.Product;

import java.util.List;

public class v_dashboard_orderdetails_bag_object {
    private int id;
    private String name;
    private double price;
    private String description;
    private List<OrderBagProducts> orderBagProducts;

    public v_dashboard_orderdetails_bag_object(int id, String name, double price, String description, List<OrderBagProducts> orderBagProducts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.orderBagProducts = orderBagProducts;
    }
}
