package com.example.demo.domain;

public class OrderLines {
    private int id;
    private int order_id;
    private int breakfastBasket_id;
    private int quantity;

    public OrderLines(int id, int order_id, int breakfastBasket_id, int quantity) {
        this.id = id;
        this.order_id = order_id;
        this.breakfastBasket_id = breakfastBasket_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getBreakfastBasket_id() {
        return breakfastBasket_id;
    }

    public void setBreakfastBasket_id(int breakfastBasket_id) {
        this.breakfastBasket_id = breakfastBasket_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
