package com.example.demo.domain;

public class BreakfastBag_ProductCategory {
    private int id;
    private int Breakfastbag_FK;
    private int ProductCategory_FK;

    public BreakfastBag_ProductCategory(int id, int breakfastbag_FK, int productCategory_FK) {
        this.id = id;
        Breakfastbag_FK = breakfastbag_FK;
        ProductCategory_FK = productCategory_FK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBreakfastbag_FK() {
        return Breakfastbag_FK;
    }

    public void setBreakfastbag_FK(int breakfastbag_FK) {
        Breakfastbag_FK = breakfastbag_FK;
    }

    public int getProductCategory_FK() {
        return ProductCategory_FK;
    }

    public void setProductCategory_FK(int productCategory_FK) {
        ProductCategory_FK = productCategory_FK;
    }
}
