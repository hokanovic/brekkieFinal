package com.example.demo.repository;

import com.example.demo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCRepository implements ShopRepository {
    private DataSource dataSource;
    private List<Order> orderList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<OrderLines> orderLinesList = new ArrayList<>();
    private List<BreakfastBag> breakfastBagsList = new ArrayList<>();
    private List<ProductCategory> productCategoryList = new ArrayList<>();
    private List<BreakfastBag_ProductCategory> breakfastBag_ProductCategoryList = new ArrayList<>();

    @Override
    //Creates a list of all Orders from database
    public List<Order> listOrders() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, customerId, orderDate," +
                     "paymentOption, marking, " +
                     "experationDate, deliveryDate, deliveryTime FROM Order")) {
            while (rs.next()) orderList.add(rsOrder(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    //Creates a list of all Producs from database
    public List<Product> listProducts() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, productCategory FROM Product")) {
            while (rs.next()) productList.add(rsProduct(rs));
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all Customers from database
    @Override
    public List<Customer> listCustomers() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  id,email, orgId, adress, deliveryAdress," +
                     " contactInfo, name FROM Customer")) {
            while (rs.next()) customerList.add(rsCustomer(rs));
            return customerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all OrderLines from database
    @Override
    public List<OrderLines> listOrderLines() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  id, order_id," +
                     "breakfastBasket_id, quantity FROM OrderLines")) {
            while (rs.next()) orderLinesList.add(rsOrderLines(rs));
            return orderLinesList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all ProductCategory from database
    @Override
    public List<ProductCategory> listProductCategory() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  id, name FROM OrderLines")) {
            while (rs.next()) productCategoryList.add(rsProductCategory(rs));
            return productCategoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all BreakfastBags from database
    @Override
    public List<BreakfastBag> listBreakfastBag() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  id, name FROM BreakfastBags")) {
            while (rs.next()) breakfastBagsList.add(rsBreakfastBag(rs));
            return breakfastBagsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all BreakfastBag_ProductCategorys from database
    @Override
    public List<BreakfastBag_ProductCategory> listbreakfastBag_ProductCategory() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  id, " +
                     "Breakfastbag_FK, " +
                     "ProductCategory_FK FROM BreakfastBag_ProductCategory")) {
            while (rs.next()) breakfastBag_ProductCategoryList.add(rsBreakfastBag_ProductCategoryList(rs));
            return breakfastBag_ProductCategoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds order to database
    @Override
    public void addOrder(int id, int customerId, String orderDate, String paymentOption, String marking,
                         String experationDate, String deliveryDate, String deliveryTime) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO order(id, customerID, orderDate, paymentOption," +
                     "marking, experationDate, deliveryDate, deliveryTime) VALUES (?,?,?,?,?,?,?,?) ", new String[]{"id"})) {
            ps.setInt(1, id);
            ps.setInt(2, customerId);
            ps.setString(3, orderDate);
            ps.setString(4, paymentOption);
            ps.setString(5, marking);
            ps.setString(6, experationDate);
            ps.setString(7, deliveryDate);
            ps.setString(8, deliveryTime);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Adds product to database
    @Override
    public void addProduct(int id, String name, int productCategory_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO product(id, name, productCategory_id) " +
                     "VALUES (?,?,?) ", new String[]{"id"})) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, productCategory_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds customer to database
    @Override
    public void addCustomer(int id, String email, String orgId, String adress, String deliveryAdress,
                            String contactInfo, String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                     "Customer(id, email, orgId, adress, deliveryAdress, contactInfo, name)" +
                     "VALUES (?,?,?,?,?,?,?) ", new String[]{"id"})) {
            ps.setInt(1, id);
            ps.setString(2, email);
            ps.setString(3, orgId);
            ps.setString(4, adress);
            ps.setString(5, deliveryAdress);
            ps.setString(6, contactInfo);
            ps.setString(7, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds OrderLines to database
    @Override
    public void addOrderLines(int id, int order_id, int breakfastBasket_id, int quantity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                     "OrderLines(id, order_id, breakfastBasket_id, quantity " +
                     "VALUES (?,?,?,?) ", new String[]{"id"})) {
            ps.setInt(1, id);
            ps.setInt(2, order_id);
            ps.setInt(3, breakfastBasket_id);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds BreakfastBag to database
    @Override
    public void addBreakfastBag(int id, String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO" +
                     "BreakfastBag(id, name VALUES (?,?) ", new String[]{"id"})) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds ProductCategory to database
    @Override
    public void addProductCategory(int id, String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO" +
                     "ProductCategory(id, name VALUES (?,?) ", new String[]{"id"})) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds BreakfastBag_ProductCategory to database
    @Override
    public void addBreakfastBag_ProductCategory(int id, int Breakfastbag_FK,int ProductCategory_FK) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO" +
                     "BreakfastBag_ProductCategory(id, BreakfastBag_FK, ProductCategory_FK" +
                     " VALUES (?,?,?) ", new String[]{"id"})) {
            ps.setInt(1, id);
            ps.setInt(2, Breakfastbag_FK);
            ps.setInt(3, ProductCategory_FK);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates new Orders from database
    private Order rsOrder(ResultSet rs) throws SQLException {
        return new Order(rs.getInt("id"), rs.getInt("customerId"), rs.getString("orderDate"),
                rs.getString("paymentOption"),rs.getBoolean("allergy"), rs.getString("marking"), rs.getString("experationDate"),
                rs.getDate("deliveryDate"), rs.getTime("deliveryTime"));
    }

    //Creates new Products from database
    private Product rsProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("productCategory"));
    }

    //Creates new Customer from database
    private Customer rsCustomer(ResultSet rs) throws SQLException {
        return new Customer(rs.getInt("id"),rs.getString("companyName"),
        rs.getString("email"), rs.getString("orgId"),
        rs.getString("reference"),rs.getString("phoneNumber"),
        rs.getString("invoiceAdress"), rs.getString("invoicePostalTown"),
        rs.getString("invoicePostNumber"), rs.getString("deliveryAdress"),
        rs.getString("deliveryPostalTown"), rs.getString("deliveryPostNumber"));

    }

    //Creates new OrderLines from database
    private OrderLines rsOrderLines(ResultSet rs) throws SQLException {
        return new OrderLines(rs.getInt("id"), rs.getInt("order_id"),
                rs.getInt("breakfastBaset_id"), rs.getInt("quantity"));
    }

    //Creates new BrekfastBag from database
    private BreakfastBag rsBreakfastBag(ResultSet rs) throws SQLException {
        return new BreakfastBag(rs.getInt("id"), rs.getString("name"));
    }

    //Creates new ProductCategory from database
    private ProductCategory rsProductCategory(ResultSet rs) throws SQLException {
        return new ProductCategory(rs.getInt("id"), rs.getString("name"));
    }

    //Creates new BreakfastBag_ProductCategoryList from database
    private BreakfastBag_ProductCategory rsBreakfastBag_ProductCategoryList(ResultSet rs)
            throws SQLException {
        return new BreakfastBag_ProductCategory(rs.getInt("id"),
                rs.getInt("breakfastBag_FK"), rs.getInt("productCategory_FK"));
    }
}
