package com.example.demo.domain.view;

import com.example.demo.domain.OrderBag;
import com.example.demo.domain.OrderBagProducts;

import java.util.List;

public class v_dash_orderdetails_orderbag {
    private OrderBag orderbag;
    private List<OrderBagProducts> orderbagproductsList;

    public v_dash_orderdetails_orderbag(OrderBag orderbag, List<OrderBagProducts> orderbagproductsList) {
        this.orderbag = orderbag;
        this.orderbagproductsList = orderbagproductsList;
    }

    public OrderBag getOrderbag() {
        return orderbag;
    }

    public void setOrderbag(OrderBag orderbag) {
        this.orderbag = orderbag;
    }

    public List<OrderBagProducts> getOrderbagproductsList() {
        return orderbagproductsList;
    }

    public void setOrderbagproductsList(List<OrderBagProducts> orderbagproductsList) {
        this.orderbagproductsList = orderbagproductsList;
    }
}
