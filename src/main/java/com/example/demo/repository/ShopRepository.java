package com.example.demo.repository;

import com.example.demo.domain.*;
import com.example.demo.domain.view.v_dashboard_order;

import java.sql.Date;
import java.util.List;

public interface ShopRepository {

    List<Order> listOrders();
    List<v_dashboard_order> listOrdersText();

    List<Product> listProducts();

    List<Customer> listCustomers();

    List<OrderLine> listOrderLines();

    List<Bag> listBags();

    List<ProductCategory> listProductCategorys();

    List<Bag_ProductCategory> listBag_ProductCategorys();

    void addCustomer(int id, String orgnr, String companyname, String contactperson, String mail);

    void addOrder(int id, Date creationdate, String additionaltext, String allergy,
            String deliveryaddress, String deliveryaddresspostalcode,
            String deliveryaddresspostaltown, String invoiceaddress,
            String invoiceaddresspostalcode, String invoiceaddresspostaltown,
            int PaymentMethod_id, int Customer_id);

    void addProduct(String name, int productCategory_id);

    void addOrderLine(int id, int order_id, int bag_id, int quantity);

    void addBag(int id, String name, int price);

    void addProductCategory(int id, String name);

    void addBag_ProductCategory(int bag_id, int productCategory_id);

}
