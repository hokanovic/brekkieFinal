package com.example.demo.domain.view;

import java.sql.Date;

public class v_dashboard_orderdetails_all {

    private int order_id;
    private Date order_creationdate;
    private String order_additionaltext;
    private String order_allergy;
    private String order_deliveryaddress;
    private String order_deliveryaddresspostalcode;
    private String order_deliveryaddresspostaltown;
    private String order_invoiceaddress;
    private String order_invoiceaddresspostalcode;
    private String order_invoiceaddresspostaltown;
    private int order_PaymentMethod_id;
    private int order_Customer_id;
    private int order_OrderStatus_id;

    private int orderbag_id;
    private int orderbag_Bag_id;
    private int orderbag_Order_id;

    private int orderbagproducts_id;
    private int orderbagproducts_OrderBag_id;
    private int orderbagproducts_Product_id;

    private int customer_id;
    private String customer_orgnr;
    private String customer_companyname;
    private String customer_contactperson;
    private String customer_mail;

    private int paymentmethod_id;
    private String paymentmethod_name;

    private int orderstatus_id;
    private String orderstatus_name;

    private int product_id;
    private String product_name;
    private int product_productCategory_id;

    private int productcategory_id;
    private String productcategory_name;

    private int orderline_id;
    private int orderline_Order_id;
    private int orderline_Bag_id;
    private int orderline_quantity;

    private int bag_id;
    private String bag_name;
    private int bag_price;

    public v_dashboard_orderdetails_all(int order_id, Date order_creationdate, String order_additionaltext, String order_allergy, String order_deliveryaddress, String order_deliveryaddresspostalcode, String order_deliveryaddresspostaltown, String order_invoiceaddress, String order_invoiceaddresspostalcode, String order_invoiceaddresspostaltown, int order_PaymentMethod_id, int order_Customer_id, int order_OrderStatus_id, int orderbag_id, int orderbag_Bag_id, int orderbag_Order_id, int orderbagproducts_id, int orderbagproducts_OrderBag_id, int orderbagproducts_Product_id, int customer_id, String customer_orgnr, String customer_companyname, String customer_contactperson, String customer_mail, int paymentmethod_id, String paymentmethod_name, int orderstatus_id, String orderstatus_name, int product_id, String product_name, int product_productCategory_id, int productcategory_id, String productcategory_name, int orderline_id, int orderline_Order_id, int orderline_Bag_id, int orderline_quantity, int bag_id, String bag_name, int bag_price) {
        this.order_id = order_id;
        this.order_creationdate = order_creationdate;
        this.order_additionaltext = order_additionaltext;
        this.order_allergy = order_allergy;
        this.order_deliveryaddress = order_deliveryaddress;
        this.order_deliveryaddresspostalcode = order_deliveryaddresspostalcode;
        this.order_deliveryaddresspostaltown = order_deliveryaddresspostaltown;
        this.order_invoiceaddress = order_invoiceaddress;
        this.order_invoiceaddresspostalcode = order_invoiceaddresspostalcode;
        this.order_invoiceaddresspostaltown = order_invoiceaddresspostaltown;
        this.order_PaymentMethod_id = order_PaymentMethod_id;
        this.order_Customer_id = order_Customer_id;
        this.order_OrderStatus_id = order_OrderStatus_id;
        this.orderbag_id = orderbag_id;
        this.orderbag_Bag_id = orderbag_Bag_id;
        this.orderbag_Order_id = orderbag_Order_id;
        this.orderbagproducts_id = orderbagproducts_id;
        this.orderbagproducts_OrderBag_id = orderbagproducts_OrderBag_id;
        this.orderbagproducts_Product_id = orderbagproducts_Product_id;
        this.customer_id = customer_id;
        this.customer_orgnr = customer_orgnr;
        this.customer_companyname = customer_companyname;
        this.customer_contactperson = customer_contactperson;
        this.customer_mail = customer_mail;
        this.paymentmethod_id = paymentmethod_id;
        this.paymentmethod_name = paymentmethod_name;
        this.orderstatus_id = orderstatus_id;
        this.orderstatus_name = orderstatus_name;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_productCategory_id = product_productCategory_id;
        this.productcategory_id = productcategory_id;
        this.productcategory_name = productcategory_name;
        this.orderline_id = orderline_id;
        this.orderline_Order_id = orderline_Order_id;
        this.orderline_Bag_id = orderline_Bag_id;
        this.orderline_quantity = orderline_quantity;
        this.bag_id = bag_id;
        this.bag_name = bag_name;
        this.bag_price = bag_price;
    }
}
