package com.example.demo.domain.view;

public class v_dashboard_orderbagproducts {
    private int id;
    private int OrderBag_id;
    private int Product_id;
    private String Product;

    public v_dashboard_orderbagproducts(int id, int orderBag_id, int product_id, String product) {
        this.id = id;
        OrderBag_id = orderBag_id;
        Product_id = product_id;
        Product = product;
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

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }
}
