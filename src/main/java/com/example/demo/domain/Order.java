package com.example.demo.domain;

import java.sql.Date;
import java.sql.Time;

public class Order {
    private int id;
    private int customerId;
    private String orderDate;
    private String paymentOption;
    private boolean allergy;
    private String marking;
    private String experationDate;
    private Date deliveryDate;
    private Time deliveryTime;

    public Order(int id, int customerId, String orderDate,
                 String paymentOption, boolean allergy, String marking,
                 String experationDate, Date deliveryDate, Time deliveryTime) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.paymentOption = paymentOption;
        this.allergy = allergy;
        this.marking = marking;
        this.experationDate = experationDate;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public boolean isAllergy() {
        return allergy;
    }

    public void setAllergy(boolean allergy) {
        this.allergy = allergy;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public String getExperationDate() {
        return experationDate;
    }

    public void setExperationDate(String experationDate) {
        this.experationDate = experationDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Time getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
