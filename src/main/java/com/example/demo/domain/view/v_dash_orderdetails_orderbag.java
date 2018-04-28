package com.example.demo.domain.view;

import com.example.demo.domain.OrderBag;

import java.util.List;

public class v_dash_orderdetails_orderbag {
    private v_dashboard_orderbag orderbag;
    private List<v_dashboard_orderbagproducts> orderbagproductsList;

    public v_dash_orderdetails_orderbag(v_dashboard_orderbag orderbag, List<v_dashboard_orderbagproducts> orderbagproductsList) {
        this.orderbag = orderbag;
        this.orderbagproductsList = orderbagproductsList;
    }

    public v_dashboard_orderbag getOrderbag() {
        return orderbag;
    }

    public void setOrderbag(v_dashboard_orderbag orderbag) {
        this.orderbag = orderbag;
    }

    public List<v_dashboard_orderbagproducts> getOrderbagproductsList() {
        return orderbagproductsList;
    }

    public void setOrderbagproductsList(List<v_dashboard_orderbagproducts> orderbagproductsList) {
        this.orderbagproductsList = orderbagproductsList;
    }
}
