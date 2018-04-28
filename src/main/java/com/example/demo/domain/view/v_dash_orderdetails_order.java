package com.example.demo.domain.view;

import com.example.demo.domain.Customer;

import java.util.List;

public class v_dash_orderdetails_order {
    private v_dashboard_order v_dashboard_Order;
    private Customer customer;
    private List<v_dash_orderdetails_orderbag> orderbagList;

    public v_dash_orderdetails_order(v_dashboard_order v_dashboard_Order, Customer customer, List<v_dash_orderdetails_orderbag> orderbagList) {
        this.v_dashboard_Order = v_dashboard_Order;
        this.customer = customer;
        this.orderbagList = orderbagList;
    }

    public v_dashboard_order getV_dashboard_Order() {
        return v_dashboard_Order;
    }

    public void setV_dashboard_Order(v_dashboard_order v_dashboard_Order) {
        this.v_dashboard_Order = v_dashboard_Order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<v_dash_orderdetails_orderbag> getOrderbagList() {
        return orderbagList;
    }

    public void setOrderbagList(List<v_dash_orderdetails_orderbag> orderbagList) {
        this.orderbagList = orderbagList;
    }
}
