package com.example.demo.repository;

import com.example.demo.domain.*;

import java.util.List;

public interface ShopRepository {
    List<Order> listOrders();

    List<Product> listProducts();

    List<Customer> listCustomers();

    List<OrderLines> listOrderLines();

    List<BreakfastBag> listBreakfastBag();

    List<ProductCategory> listProductCategory();

    List<BreakfastBag_ProductCategory> listbreakfastBag_ProductCategory();

    void addCustomer(int id, String email, String orgId, String adress, String deliveryAdress,
                     String contactInfo, String name);

    void addOrder(int id, int customerId, String orderDate, String paymentOption, String marking,
                  String experationDate, String deliveryDate, String deliveryTime);

    void addProduct(int id, String name, int productCategori_id);

    void addOrderLines(int id, int order_id, int breakfastBasket_id, int quantity);

    void addBreakfastBag(int id,String name);

    void addProductCategory(int id,String name);

    void addBreakfastBag_ProductCategory(int id, int Breakfastbag_FK,int ProductCategory_FK);

}
