package com.example.demo.domain;

public class v_dashboard_product {
    private int id;
    private String name;
    private int productCategory_id;
    private int price;
    private String productCategory_name;

    public v_dashboard_product() {

    }

    public v_dashboard_product(int id, String name, int productCategory_id, int price, String productCategory_name) {
        this.id = id;
        this.name = name;
        this.productCategory_id = productCategory_id;
        this.price = price;
        this.productCategory_name = productCategory_name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductCategory_name() {
        return productCategory_name;
    }

    public void setProductCategory_name(String productCategory_name) {
        this.productCategory_name = productCategory_name;
    }
}
