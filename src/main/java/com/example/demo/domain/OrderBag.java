package com.example.demo.domain;

public class OrderBag {
    private int id;
    private int Bag_id;
    private int Order_id;

    public OrderBag(int id, int bag_id, int order_id) {
        this.id = id;
        this.Bag_id = bag_id;
        this.Order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBag_id() {
        return Bag_id;
    }

    public void setBag_id(int bag_id) {
        Bag_id = bag_id;
    }

    public int getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(int order_id) {
        Order_id = order_id;
    }
}
