package com.example.demo.domain.view;

import java.util.List;

public class v_dashboard_orderdetails_orderline_object {
private int id;
private int quantity;
private List<v_dashboard_orderdetails_bag_object> bags;

    public v_dashboard_orderdetails_orderline_object(int id, int quantity, List<v_dashboard_orderdetails_bag_object> bags) {
        this.id = id;
        this.quantity = quantity;
        this.bags = bags;
    }
}
