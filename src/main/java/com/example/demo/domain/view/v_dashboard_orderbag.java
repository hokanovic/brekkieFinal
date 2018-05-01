package com.example.demo.domain.view;

public class v_dashboard_orderbag {
    private int id;
    private int Bag_id;
    private int Order_id;
    private String Bag;
    private double price;

    public v_dashboard_orderbag(int id, int bag_id, int order_id, String bag, double price) {
        this.id = id;
        Bag_id = bag_id;
        Order_id = order_id;
        Bag = bag;
        this.price = price;
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

    public String getBag() {
        return Bag;
    }

    public void setBag(String bag) {
        Bag = bag;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
