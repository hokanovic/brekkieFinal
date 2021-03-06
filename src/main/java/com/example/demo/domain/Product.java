package com.example.demo.domain;

public class Product {
    private int id;
    private String name;
    private int productCategory_id;
    private int price;

    public Product(){
    }

    public Product(int id, String name, int productCategory_id, int price) {
        this.id = id;
        this.name = name;
        this.productCategory_id = productCategory_id;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getProductCategory_id() {
        return productCategory_id;
    }
    public void setProductCategory_id(int productCategory_id) {
        this.productCategory_id = productCategory_id;
    }
}
