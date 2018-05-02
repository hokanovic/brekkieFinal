package com.example.demo.domain.OrderView;

import com.example.demo.domain.Bag;

import java.util.List;

public class OrderView_ContentsOfBag {
    private Bag bag;
    private List<OrderView_ContentsOfCategory> orderView_ContentsOfCategoryList;

    public OrderView_ContentsOfBag(Bag bag, List<OrderView_ContentsOfCategory> orderView_ContentsOfCategoryList) {
        this.bag = bag;
        this.orderView_ContentsOfCategoryList = orderView_ContentsOfCategoryList;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public List<OrderView_ContentsOfCategory> getOrderView_ContentsOfCategoryList() {
        return orderView_ContentsOfCategoryList;
    }

    public void setOrderView_ContentsOfCategoryList(List<OrderView_ContentsOfCategory> orderView_ContentsOfCategoryList) {
        this.orderView_ContentsOfCategoryList = orderView_ContentsOfCategoryList;
    }
}