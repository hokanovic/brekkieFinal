package com.example.demo;

import com.example.demo.domain.JsonOrder;

import java.util.ArrayList;

public class Cart {
    private ArrayList<JsonOrder> jsonOrders;

    public Cart() {
        this.jsonOrders = new ArrayList<>();
    }

    public ArrayList<JsonOrder> getJsonOrders() {
        return jsonOrders;
    }

    public void setJsonOrders(ArrayList<JsonOrder> jsonOrders) {
        this.jsonOrders = jsonOrders;
    }
}
