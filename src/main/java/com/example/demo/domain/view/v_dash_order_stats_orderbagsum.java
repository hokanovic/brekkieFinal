package com.example.demo.domain.view;

public class v_dash_order_stats_orderbagsum {
    private int bagid;
    private String bagname;
    private int quantity;
    private int sum;

    public int getBagid() {
        return bagid;
    }

    public void setBagid(int bagid) {
        this.bagid = bagid;
    }

    public String getBagname() {
        return bagname;
    }

    public void setBagname(String bagname) {
        this.bagname = bagname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public v_dash_order_stats_orderbagsum(int bagid, String bagname, int quantity, int sum) {

        this.bagid = bagid;
        this.bagname = bagname;
        this.quantity = quantity;
        this.sum = sum;
    }
}
