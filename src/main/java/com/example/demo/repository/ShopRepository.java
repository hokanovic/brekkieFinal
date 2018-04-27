package com.example.demo.repository;

import com.example.demo.domain.*;
import com.example.demo.domain.view.v_dashboard_order;

import java.sql.Date;
import java.util.List;

public interface ShopRepository {

    List<Order> listOrders();
    List<v_dashboard_order> listOrdersText();
    List<OrderStatus> listOrderStatuses();
    List<v_dashboard_order> listOrdersTextP(int OrderStatus);
    List<Product> listProducts();

    List<Customer> listCustomers();

    List<OrderLine> listOrderLines();

    List<Bag> listBags();

    List<ProductCategory> listProductCategorys();

    List<Bag_ProductCategory> listBag_ProductCategorys();

    void addCustomer(String orgnr, String companyname, String contactperson, String mail);

    void addOrder(Date creationdate, String additionaltext, String allergy,
            String deliveryaddress, String deliveryaddresspostalcode,
            String deliveryaddresspostaltown, String invoiceaddress,
            String invoiceaddresspostalcode, String invoiceaddresspostaltown,
            int PaymentMethod_id, int Customer_id, int OrderStatus_id);

    void addProduct(String name, int productCategory_id);

    void addOrderLine(int order_id, int bag_id, int quantity);

    void addBag(String name, int price,String description);

    void addProductCategory(String name);

    void addBag_ProductCategory(int bag_id, int productCategory_id);

}
