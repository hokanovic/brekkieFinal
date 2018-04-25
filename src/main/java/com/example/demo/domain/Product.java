package com.example.demo.domain;

public class Product {
    private int id;
    private String name;
    private int productCategori_id;

    public Product(int id, String name, int productCategori_id) {
        this.id = id;
        this.name = name;
        this.productCategori_id = productCategori_id;
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
        return productCategori_id;
    }

    public void setProductCategori_id(int productCategori_id) {
        this.productCategori_id = productCategori_id;
    }
}
