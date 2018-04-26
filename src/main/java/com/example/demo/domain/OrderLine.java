package com.example.demo.domain;

public class OrderLine {
    private int id;
    private int Order_id;
    private int Bag_id;
    private int quantity;

    public OrderLine(int id, int order_id, int bag_id, int quantity) {
        this.id = id;
        this.Order_id = order_id;
        this.Bag_id = bag_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(int order_id) {
        Order_id = order_id;
    }

    public int getBag_id() {
        return Bag_id;
    }

    public void setBag_id(int bag_id) {
        Bag_id = bag_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
