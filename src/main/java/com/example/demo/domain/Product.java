package com.example.demo.domain;

public class Product {
    private int id;
    private String name;
    private int productCategory_id;

    public Product(int id, String name, int productCategory_id) {
        this.id = id;
        this.name = name;
        this.productCategory_id = productCategory_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCategori_id() {
        return productCategory_id;
    }

    public void setProductCategori_id(int productCategory_id) {
        this.productCategory_id = productCategory_id;
    }
}
