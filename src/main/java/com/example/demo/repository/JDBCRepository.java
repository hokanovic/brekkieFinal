package com.example.demo.repository;

import com.example.demo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Component
public class JDBCRepository implements ShopRepository {
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Override
    //Creates a list of all Orders from database
    public List<Order> listOrders() {
        List<Order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, creationdate, additionaltext," +
                             " allergy, deliveryaddress, deliveryaddresspostalcode, " +
                     "deliveryaddresspostaltown, invoiceaddress, invoiceaddresspostalcode, " +
                     "invoiceaddresspostaltown, paymentMethod_id, customer_id FROM \"Order\"")) {
            while (rs.next()) orderList.add(rsOrder(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    //Creates a list of all Producs from database
    public List<Product> listProducts() {
        List<Product> productList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, " +
                     "productCategory_id FROM \"Product\"")) {
            while (rs.next()) productList.add(rsProduct(rs));
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Creates a list of all Customers from database

    @Override
    public List<Customer> listCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, orgnr, " +
                     "companyname, contactperson, mail FROM \"Customer\"")) {
            while (rs.next()) customerList.add(rsCustomer(rs));
            return customerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all OrderLine from database
    @Override
    public List<OrderLine> listOrderLines() {
        List<OrderLine> orderLineList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, " +
                     "order_id, bag_id, quantity FROM \"OrderLine\"")) {
            while (rs.next()) orderLineList.add(rsOrderLine(rs));
            return orderLineList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all ProductCategory from database
    @Override
    public List<ProductCategory> listProductCategorys() {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name FROM \"OrderLines\"")) {
            while (rs.next()) productCategoryList.add(rsProductCategory(rs));
            return productCategoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all BreakfastBags from database
    @Override
    public List<Bag> listBags() {
        List<Bag> breakfastBagsList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  id, name, price FROM \"Bag\"")) {
            while (rs.next()) breakfastBagsList.add(rsBreakfastBag(rs));
            return breakfastBagsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list of all BreakfastBag_ProductCategorys from database
    @Override
    public List<Bag_ProductCategory> listBag_ProductCategorys() {
        List<Bag_ProductCategory> breakfastBag_ProductCategoryList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  bag_id, " +
                     "productCategory_id FROM \"BreakfastBag_ProductCategory\"")) {
            while (rs.next()) breakfastBag_ProductCategoryList.add(rsBreakfastBag_ProductCategoryList(rs));
            return breakfastBag_ProductCategoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds order to database
    @Override
    public void addOrder(int id, Date creationdate, String additionaltext, String allergy,
                         String deliveryaddress, String deliveryaddresspostalcode,
                         String deliveryaddresspostaltown, String invoiceaddress,
                         String invoiceaddresspostalcode, String invoiceaddresspostaltown,
                         int PaymentMethod_id, int Customer_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Order\" (id, customerID, orderDate, paymentOption," +
                     "marking, experationDate, deliveryDate, deliveryTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ")) {
            ps.setInt(1, id);
            ps.setDate(2, creationdate);
            ps.setString(3, additionaltext);
            ps.setString(4, allergy);
            ps.setString(5, deliveryaddress);
            ps.setString(6, deliveryaddresspostalcode);
            ps.setString(7, deliveryaddresspostaltown);
            ps.setString(8, invoiceaddress);
            ps.setString(9, invoiceaddresspostalcode);
            ps.setString(10, invoiceaddresspostaltown);
            ps.setInt(11,PaymentMethod_id);
            ps.setInt(12,Customer_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Adds product to database
    @Override
    public void addProduct(int id, String name, int productCategory_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Product\" (id, name, productCategory_id) " +
                     "VALUES (?,?,?) ")) {
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
    public void addCustomer(int id, String orgnr, String companyname, String contactperson, String mail) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                     "\"Customer\" (id, orgnr, " +
                     "companyname, contactperson, mail)" +
                     "VALUES (?,?,?,?,?) ")) {
            ps.setInt(1, id);
            ps.setString(2, orgnr);
            ps.setString(3, companyname);
            ps.setString(4, contactperson);
            ps.setString(5, mail);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds OrderLine to database
    @Override
    public void addOrderLine(int id, int order_id, int bag_id, int quantity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                     "\"OrderLine\" (id, order_id, bag_id, quantity) " +
                     "VALUES (?,?,?,?) ")) {
            ps.setInt(1, id);
            ps.setInt(2, order_id);
            ps.setInt(3, bag_id);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //insert into "Bag" values (1, 'Liten',100);
    //Adds Bag to database
    @Override
    public void addBag(int id, String name, int price) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Bag\" (id, name, price) VALUES (?,?,?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, price);
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
                     "\"ProductCategory\" (id, name) VALUES (?,?) ")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds Bag_ProductCategory to database
    @Override
    public void addBag_ProductCategory(int bag_id, int productCategory_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO" +
                     "\"Bag_ProductCategory\" (bag_id, productCategory_id)" +
                     " VALUES (?,?) ")) {
            ps.setInt(1, bag_id);
            ps.setInt(2, productCategory_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates new Orders from database
    private Order rsOrder(ResultSet rs) throws SQLException {
        return new Order(rs.getInt("id"), rs.getDate("creationdate"),
                rs.getString("additionaltext"),
                rs.getString("allergy"), rs.getString("deliveryaddress"),
                rs.getString("deliveryaddresspostalcode"),
                rs.getString("deliveryaddresspostaltown"),
                rs.getString("invoiceaddress"),
                rs.getString("invoiceaddresspostalcode"),
                rs.getString("invoiceaddresspostaltown"),
        rs.getInt("paymentMethod_id"),
        rs.getInt("customer_id"));
    }

    //Creates new Products from database
    private Product rsProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("productCategory_id"));
    }

    //Creates new Customer from database
    private Customer rsCustomer(ResultSet rs) throws SQLException {
        return new Customer(rs.getInt("id"),
                rs.getString("orgnr"), rs.getString("companyname"),
                rs.getString("contactperson"),
                rs.getString("mail"));
    }

    //Creates new OrderLine from database
    private OrderLine rsOrderLine(ResultSet rs) throws SQLException {
        return new OrderLine(rs.getInt("id"),
        rs.getInt("order_id"),
        rs.getInt("bag_id"),
        rs.getInt("quantity"));
    }

    //Creates new Bag from database
    private Bag rsBreakfastBag(ResultSet rs) throws SQLException {
        return new Bag(rs.getInt("id"),
                rs.getString("name"),
        rs.getInt("price"));
    }

    //Creates new ProductCategory from database
    private ProductCategory rsProductCategory(ResultSet rs) throws SQLException {
        return new ProductCategory(rs.getInt("id"), rs.getString("name"));
    }

    //Creates new Bag_ProductCategoryList from database
    private Bag_ProductCategory rsBreakfastBag_ProductCategoryList(ResultSet rs)
            throws SQLException {
        return new Bag_ProductCategory(rs.getInt("bag_id"),
                rs.getInt("productCategory_id"));
    }
}
