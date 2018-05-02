package com.example.demo.domain.OrderView;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductCategory;

import java.util.List;

public class OrderView_ContentsOfCategory {
    private ProductCategory productCategory;
    private List<Product> productList;

    public OrderView_ContentsOfCategory(ProductCategory productCategory, List<Product> productList) {
        this.productCategory = productCategory;
        this.productList = productList;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
