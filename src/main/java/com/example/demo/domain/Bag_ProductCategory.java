package com.example.demo.domain;

public class Bag_ProductCategory {
    private int Bag_id;
    private int ProductCategory_id;

    public Bag_ProductCategory(int bag_id, int productCategory_id) {
        this.Bag_id = bag_id;
        this.ProductCategory_id = productCategory_id;
    }

    public int getBag_id() {
        return Bag_id;
    }

    public void setBag_id(int bag_id) {
        Bag_id = bag_id;
    }

    public int getProductCategory_id() {
        return ProductCategory_id;
    }

    public void setProductCategory_id(int productCategory_id) {
        ProductCategory_id = productCategory_id;
    }
}
