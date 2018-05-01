package com.example.demo.domain.view;

public class v_dash_order_stats {
    int totalSum;

    public v_dash_order_stats(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }
}
