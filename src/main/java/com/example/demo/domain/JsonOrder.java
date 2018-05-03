package com.example.demo.domain;

public class JsonOrder {
    private String productName;
    private String bagId;
    private String productId;
    private String productQty;

    public JsonOrder(){
    }

    public JsonOrder(String productName, String bagId, String productId, String productQty) {
        this.productName = productName;
        this.bagId = bagId;
        this.productId = productId;
        this.productQty = productQty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBagId() {
        return bagId;
    }

    public void setBagId(String bagId) {
        this.bagId = bagId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }
}