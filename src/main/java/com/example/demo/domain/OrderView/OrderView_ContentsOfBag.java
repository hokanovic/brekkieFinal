package com.example.demo.domain.OrderView;

import com.example.demo.domain.Bag;

import java.util.List;

public class OrderView_ContentsOfBag {
    private Bag bag;
    private List<OrderView_ContentsOfCategory> orderView_contentsOfCategoryList;

    public OrderView_ContentsOfBag(Bag bag, List<OrderView_ContentsOfCategory> orderView_contentsOfCategoryList) {
        this.bag = bag;
        this.orderView_contentsOfCategoryList = orderView_contentsOfCategoryList;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public List<OrderView_ContentsOfCategory> getOrderView_contentsOfCategoryList() {
        return orderView_contentsOfCategoryList;
    }

    public void setOrderView_contentsOfCategoryList(List<OrderView_ContentsOfCategory> orderView_contentsOfCategoryList) {
        this.orderView_contentsOfCategoryList = orderView_contentsOfCategoryList;
    }
}