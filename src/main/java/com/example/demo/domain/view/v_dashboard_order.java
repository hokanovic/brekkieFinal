package com.example.demo.domain.view;

import java.sql.Date;

public class v_dashboard_order {
    private int id;
    private Date creationdate;
    private String additionaltext;
    private String allergy;
    private String deliveryaddress;
    private String deliveryaddresspostalcode;
    private String deliveryaddresspostaltown;
    private String invoiceaddress;
    private String invoiceaddresspostalcode;
    private String invoiceaddresspostaltown;
    private String PaymentMethod;
    private String Customer;
    private String OrderStatus;

    public v_dashboard_order(int id, Date creationdate, String additionaltext, String allergy, String deliveryaddress, String deliveryaddresspostalcode, String deliveryaddresspostaltown, String invoiceaddress, String invoiceaddresspostalcode, String invoiceaddresspostaltown, String paymentMethod, String customer, String orderStatus) {
        this.id = id;
        this.creationdate = creationdate;
        this.additionaltext = additionaltext;
        this.allergy = allergy;
        this.deliveryaddress = deliveryaddress;
        this.deliveryaddresspostalcode = deliveryaddresspostalcode;
        this.deliveryaddresspostaltown = deliveryaddresspostaltown;
        this.invoiceaddress = invoiceaddress;
        this.invoiceaddresspostalcode = invoiceaddresspostalcode;
        this.invoiceaddresspostaltown = invoiceaddresspostaltown;
        PaymentMethod = paymentMethod;
        Customer = customer;
        OrderStatus = orderStatus;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getAdditionaltext() {
        return additionaltext;
    }

    public void setAdditionaltext(String additionaltext) {
        this.additionaltext = additionaltext;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    public String getDeliveryaddresspostalcode() {
        return deliveryaddresspostalcode;
    }

    public void setDeliveryaddresspostalcode(String deliveryaddresspostalcode) {
        this.deliveryaddresspostalcode = deliveryaddresspostalcode;
    }

    public String getDeliveryaddresspostaltown() {
        return deliveryaddresspostaltown;
    }

    public void setDeliveryaddresspostaltown(String deliveryaddresspostaltown) {
        this.deliveryaddresspostaltown = deliveryaddresspostaltown;
    }

    public String getInvoiceaddress() {
        return invoiceaddress;
    }

    public void setInvoiceaddress(String invoiceaddress) {
        this.invoiceaddress = invoiceaddress;
    }

    public String getInvoiceaddresspostalcode() {
        return invoiceaddresspostalcode;
    }

    public void setInvoiceaddresspostalcode(String invoiceaddresspostalcode) {
        this.invoiceaddresspostalcode = invoiceaddresspostalcode;
    }

    public String getInvoiceaddresspostaltown() {
        return invoiceaddresspostaltown;
    }

    public void setInvoiceaddresspostaltown(String invoiceaddresspostaltown) {
        this.invoiceaddresspostaltown = invoiceaddresspostaltown;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }
}
