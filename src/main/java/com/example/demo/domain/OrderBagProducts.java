package com.example.demo.domain;

public class OrderBagProducts {
    private int id;
    private int OrderBag_id;
    private int Product_id;

    public OrderBagProducts(int id, int orderBag_id, int product_id) {
        this.id = id;
        this.OrderBag_id = orderBag_id;
        this.Product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderBag_id() {
        return OrderBag_id;
    }

    public void setOrderBag_id(int orderBag_id) {
        OrderBag_id = orderBag_id;
    }

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }
}
