package com.example.demo.repository;

import com.example.demo.domain.*;
import com.example.demo.domain.OrderView.OrderView_ContentsOfBag;
import com.example.demo.domain.view.*;

import java.sql.Date;
import java.util.List;

public interface ShopRepository {
    List<Location> getLocations();
    List<v_dashboard_order> listOrdersTextPOrderStatusByCalendar(int OrderStatus,Date Date);
    List<Order> listOrders();
    List<v_dashboard_order> listOrdersText();
    List<OrderStatus> listOrderStatuses();
    List<v_dashboard_order> listOrdersTextP(int OrderStatus);
    List<Product> listProducts();
    v_dash_orderdetails_order listV_dash_orderdetails_order(int Orderid);
    Customer listCustomer(int Orderid);
    List<v_dashboard_order> listCustomerOrders(String mail);
    List<v_dashboard_order> listOrdersTextPwhereOrderEquals(int Orderid);
    v_dash_orderdetails_order listV_dash_orderdetails_orderWhereOrderidEquals(int Orderid);

    List<OrderView_ContentsOfBag> listContentsOfBag();

    List<v_dashboard_order> listOrdersTextPOrderStatus(int OrderStatus);
    v_dash_order_stats fetchOrderStats(int Orderid);
    List<v_dashboard_product> listProductsWithProductCategory();
    List<v_dashboard_product> listProductsWithProductCategorySortedByProductCategory(int PC_id);
    List<v_dash_order_stats_orderbagsum> fetchOrderStats2(int Orderid);

    List<Customer> listCustomers();

    List<OrderLine> listOrderLines();

    List<Bag> listBags();

    List<Bag> listBagById(int id);

    List<ProductCategory> listProductCategorys();

    List<ProductCategory> listProductCategoriesByBagId(int id);

    List<Product> listProductsByCatId(int id);

    List<Bag_ProductCategory> listBag_ProductCategorys();

    int addCustomer(String orgnr, String companyname, String contactperson, String mail);

   void addOrder(Date creationdate, Date deliverydate,String additionaltext, String allergy,
                         String deliveryaddress, String deliveryaddresspostalcode,
                         String deliveryaddresspostaltown, String invoiceaddress,
                         String invoiceaddresspostalcode, String invoiceaddresspostaltown,
                         int PaymentMethod_id, int Customer_id, int OrderStatus_id, double lat, double lng);

    void addProduct(String name, int productCategory_id, int price);

    void addOrderLine(int order_id, int bag_id, int quantity);

    void addBag(String name, int price,String description);

    void addProductCategory(String name);

    void addBag_ProductCategory(int bag_id, int productCategory_id);

    void updateOrderStatus(int Orderstatus, int Orderid);

}
