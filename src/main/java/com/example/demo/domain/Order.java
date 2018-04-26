package com.example.demo.domain;

import java.sql.Date;
import java.sql.Time;

public class Order {
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
    private int PaymentMethod_id;
    private int Customer_id;
    private int OrderStatus_id;

    public Order(int id, Date creationdate, String additionaltext, String allergy,
                 String deliveryaddress, String deliveryaddresspostalcode, String deliveryaddresspostaltown,
                 String invoiceaddress, String invoiceaddresspostalcode,
                 String invoiceaddresspostaltown, int paymentMethod_id, int customer_id, int OrderStatus_id) {
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
        this.PaymentMethod_id = paymentMethod_id;
        this.Customer_id = customer_id;
        this.OrderStatus_id = OrderStatus_id;
    }

    public int getOrderStatus_id() {
        return OrderStatus_id;
    }

    public void setOrderStatus_id(int orderStatus_id) {
        OrderStatus_id = orderStatus_id;
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

    public int getPaymentMethod_id() {
        return PaymentMethod_id;
    }

    public void setPaymentMethod_id(int paymentMethod_id) {
        PaymentMethod_id = paymentMethod_id;
    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int customer_id) {
        Customer_id = customer_id;
    }
}
