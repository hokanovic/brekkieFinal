package com.example.demo.repository;

import com.example.demo.domain.*;
import com.example.demo.domain.view.*;
import org.aspectj.weaver.ast.Or;
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
    public List<OrderStatus> listOrderStatuses() {
        List<OrderStatus> orderStatusList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM \"OrderStatus\"")) {
            while (rs.next()) orderStatusList.add(rsOrderStatus(rs));
            return orderStatusList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //Creates a list of all Orders from database
    public List<Order> listOrders() {
        List<Order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM \"Order\"")) {
            while (rs.next()) orderList.add(rsOrder(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    //Creates a list of all Orders from database
    public List<v_dashboard_order> listOrdersText() {
        List<v_dashboard_order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT O.id, O.creationdate, O.additionaltext, O.allergy, O.deliveryaddress, O.deliveryaddresspostalcode, O.deliveryaddresspostaltown, O.invoiceaddress, O.invoiceaddresspostalcode, O.invoiceaddresspostaltown, P.\"name\", C.\"mail\", OS.\"name\" FROM \"Order\" as O " +
                     "INNER JOIN \"Customer\" AS C ON O.\"Customer_id\" = C.\"id\"" +
                     "INNER JOIN \"PaymentMethod\" AS P ON O.\"PaymentMethod_id\" = P.\"id\"" +
                     "INNER JOIN \"OrderStatus\" AS OS ON O.\"OrderStatus_id\" = OS.\"id\"")) {
            while (rs.next()) orderList.add(rsv_dashboard_order(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //Creates a list of all Orders from database
    public List<v_dashboard_order> listOrdersTextP(int OrderStatus) {
        List<v_dashboard_order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT O.id, O.creationdate, O.additionaltext, O.allergy, O.deliveryaddress, O.deliveryaddresspostalcode, O.deliveryaddresspostaltown, O.invoiceaddress, O.invoiceaddresspostalcode, O.invoiceaddresspostaltown, P.\"name\", C.\"mail\", OS.\"name\" FROM \"Order\" as O " +
                     "INNER JOIN \"Customer\" AS C ON O.\"Customer_id\" = C.\"id\"" +
                     "INNER JOIN \"PaymentMethod\" AS P ON O.\"PaymentMethod_id\" = P.\"id\"" +
                     "INNER JOIN \"OrderStatus\" AS OS ON O.\"OrderStatus_id\" = OS.\"id\"" +
                     "where OS.\"id\" = ?")) {
            ps.setInt(1, OrderStatus);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) orderList.add(rsv_dashboard_order(rs));
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
                     "\"ProductCategory_id\" FROM \"Product\"")) {
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
                     "\"Order_id\", \"Bag_id\", quantity FROM \"Orderline\"")) {
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
             ResultSet rs = stmt.executeQuery("SELECT id, name FROM \"ProductCategory\"")) {
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
             ResultSet rs = stmt.executeQuery("SELECT id, name, price, description FROM \"Bag\"")) {
            while (rs.next()) breakfastBagsList.add(rsBreakfastBag(rs));
            return breakfastBagsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates a list containing one single Bag from database based on id of that Bag
    @Override
    public List<Bag> listBagById(int id) {
        List<Bag> breakfastBagsList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, price, description FROM \"Bag\" where id = " + id)) {
            while (rs.next()) breakfastBagsList.add(rsBreakfastBag(rs));
            return breakfastBagsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //(Beginning) WORK IN PROGRESS NEEDS REVIEW (LECOQ)
    //Get a bag from database
    /*@Override
    public Bag getBag(int id) {
        Bag breakfastBag;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  name, price, description FROM \"Bag\" where id = " + id)) {
            if (rs.next()) {
                breakfastBag = new Bag(id,
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"));
            }
            return breakfastBag;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    //(END) WORK IN PROGRESS NEEDS REVIEW (LECOQ)

    //Creates a list of all BreakfastBag_ProductCategorys from database
    @Override
    public List<Bag_ProductCategory> listBag_ProductCategorys() {
        List<Bag_ProductCategory> breakfastBag_ProductCategoryList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  \"Bag_id\", " +
                     "\"ProductCategory_id\" FROM \"Bag_ProductCategory\"")) {
            while (rs.next()) breakfastBag_ProductCategoryList.add(rsBreakfastBag_ProductCategoryList(rs));
            return breakfastBag_ProductCategoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds order to database
    @Override
    public void addOrder(Date creationdate, String additionaltext, String allergy,
                         String deliveryaddress, String deliveryaddresspostalcode,
                         String deliveryaddresspostaltown, String invoiceaddress,
                         String invoiceaddresspostalcode, String invoiceaddresspostaltown,
                         int PaymentMethod_id, int Customer_id, int OrderStatus_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Order\" (creationdate, additionaltext, allergy, deliveryaddress," +
                     "deliveryaddresspostalcode, deliveryaddresspostaltown, invoiceaddress, invoiceaddresspostalcode, invoiceaddresspostaltown, \"PaymentMethod_id\", " +
                     "\"Customer_id\", \"OrderStatus_id\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ")) {
            ps.setDate(1, creationdate);
            ps.setString(2, additionaltext);
            ps.setString(3, allergy);
            ps.setString(4, deliveryaddress);
            ps.setString(5, deliveryaddresspostalcode);
            ps.setString(6, deliveryaddresspostaltown);
            ps.setString(7, invoiceaddress);
            ps.setString(8, invoiceaddresspostalcode);
            ps.setString(9, invoiceaddresspostaltown);
            ps.setInt(10, PaymentMethod_id);
            ps.setInt(11, Customer_id);
            ps.setInt(12, OrderStatus_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Adds product to database
    @Override
    public void addProduct(String name, int ProductCategory_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Product\" (name, \"ProductCategory_id\") VALUES (?,?)")) {
            ps.setString(1, name);
            ps.setInt(2, ProductCategory_id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds customer to database
    @Override
    public void addCustomer(String orgnr, String companyname, String contactperson, String mail) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                     "\"Customer\" (orgnr, " +
                     "companyname, contactperson, mail)" +
                     "VALUES (?,?,?,?) ")) {
            ps.setString(1, orgnr);
            ps.setString(2, companyname);
            ps.setString(3, contactperson);
            ps.setString(4, mail);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds OrderLine to database
    @Override
    public void addOrderLine(int Order_id, int Bag_id, int quantity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                     "\"Orderline\" (\"Order_id\", \"Bag_id\", quantity) " +
                     "VALUES (?,?,?) ")) {
            ps.setInt(1, Order_id);
            ps.setInt(2, Bag_id);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds Bag to database
    @Override
    public void addBag(String name, int price,String description) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Bag\" (name, price, description) VALUES (?,?,?)")) {
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3,description);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds ProductCategory to database
    @Override
    public void addProductCategory(String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO" +
                     "\"ProductCategory\" (name) VALUES (?) ")) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adds Bag_ProductCategory to database
    @Override
    public void addBag_ProductCategory(int Bag_id, int productCategory_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO" +
                     "\"Bag_ProductCategory\" (\"Bag_id\", \"ProductCategory_id\")" +
                     " VALUES (?,?) ")) {
            ps.setInt(1, Bag_id);
            ps.setInt(2, productCategory_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Creates new Orders from database
    private Order rsOrder(ResultSet rs) throws SQLException {
        return new Order(rs.getInt("id"),
                rs.getDate("creationdate"),
                rs.getString("additionaltext"),
                rs.getString("allergy"),
                rs.getString("deliveryaddress"),
                rs.getString("deliveryaddresspostalcode"),
                rs.getString("deliveryaddresspostaltown"),
                rs.getString("invoiceaddress"),
                rs.getString("invoiceaddresspostalcode"),
                rs.getString("invoiceaddresspostaltown"),
                rs.getInt("paymentMethod_id"),
                rs.getInt("customer_id"),
                rs.getInt("orderstatus_id"));
    }

    //Creates new Orders from database
    private OrderStatus rsOrderStatus(ResultSet rs) throws SQLException {
        return new OrderStatus(rs.getInt("id"), rs.getString("name"));
    }

    //Creates new Orders from database
    private v_dashboard_order rsv_dashboard_order(ResultSet rs) throws SQLException {
        return new v_dashboard_order(
                rs.getInt("id"),
                rs.getDate("creationdate"),
                rs.getString("additionaltext"),
                rs.getString("allergy"),
                rs.getString("deliveryaddress"),
                rs.getString("deliveryaddresspostalcode"),
                rs.getString("deliveryaddresspostaltown"),
                rs.getString("invoiceaddress"),
                rs.getString("invoiceaddresspostalcode"),
                rs.getString("invoiceaddresspostaltown"),
                rs.getString(11),
                rs.getString(12),
                rs.getString(13));
    }

    //Creates new Products from database
    private Product rsProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("productCategory_id"));
    }

    //Creates new Customer from database
    private Customer rsCustomer(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("orgnr"),
                rs.getString("companyname"),
                rs.getString("contactperson"),
                rs.getString("mail")
        );
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
                rs.getInt("price"),
                rs.getString("description"));
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


    @Override
    public v_dash_orderdetails_order listV_dash_orderdetails_order(int Orderid) {
//        private v_dashboard_order v_dashboard_Order;
//        private Customer customer;
//        private List<v_dash_orderdetails_orderbag> orderbagList;

        v_dashboard_order v_dashboard_Order = listOrdersTextP(Orderid).get(0);
        Customer customer = listCustomer(Orderid);
        List<v_dash_orderdetails_orderbag> orderbagList = listOrderBags(Orderid);

        return new v_dash_orderdetails_order(v_dashboard_Order,customer,orderbagList);
    }


    public List<v_dash_orderdetails_orderbag> listOrderBags(int Orderid) {
//        private OrderBag orderbag;
//        private List<OrderBagProducts> orderbagproductsList;

        List<v_dash_orderdetails_orderbag> orderbagList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select * " +
                     "from \"OrderBag\" " +
                     "where \"Order_id\" = ?")) {
            ps.setInt(1,Orderid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                v_dashboard_orderbag orderBag = listV_dashboard_orderbag(rs.getInt(1));
                List<v_dashboard_orderbagproducts> orderBagProductsList = listV_dashboard_orderbagproducts(rs.getInt(1));

                orderbagList.add(new v_dash_orderdetails_orderbag(orderBag,orderBagProductsList));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderbagList;
    }

    private OrderBagProducts rsOrderBagProduct(ResultSet rs)  throws SQLException  {
        return new OrderBagProducts(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3)
        );
    }

    private OrderBag listOrderBag(int Orderid) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select * " +
                     "from \"OrderBag\"" +
                     "where \"Order_id\" = ?")) {
            ps.setInt(1, Orderid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rsOrderBag(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private v_dashboard_orderbag listV_dashboard_orderbag(int OrderBag_id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "select OB.\"id\", OB.\"Bag_id\", OB.\"Order_id\", B.\"name\" " +
                     "from \"OrderBag\" AS OB " +
                     "INNER JOIN \"Bag\" AS B ON OB.\"Bag_id\" = B.\"id\" " +
                     "where OB.\"id\" = ?")) {
            ps.setInt(1, OrderBag_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rsV_dashboard_orderbag(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private OrderBag rsOrderBag(ResultSet rs) throws SQLException {
        return new OrderBag(
            rs.getInt(1),
            rs.getInt(2),
            rs.getInt(3)
        );
    }

    @Override
    public Customer listCustomer(int Orderid) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, orgnr, companyname, contactperson, mail " +
                     "FROM \"Customer\"" +
                     "where \"id\" = ?")) {
            ps.setInt(1, Orderid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rsCustomer(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private v_dashboard_orderbag rsV_dashboard_orderbag(ResultSet rs) throws SQLException {
        return new v_dashboard_orderbag(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
        );
    }

    private v_dashboard_orderbagproducts rsV_dashboard_orderbagproducts(ResultSet rs)  throws SQLException  {
        return new v_dashboard_orderbagproducts(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5)
        );
    }

    private List<v_dashboard_orderbagproducts> listV_dashboard_orderbagproducts(int OrderBag_id) {
        List<v_dashboard_orderbagproducts> orderBagProductsList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "select OBP.\"id\", OBP.\"OrderBag_id\", OBP.\"Product_id\", P.\"name\", PC.\"name\" " +
                             "from \"OrderBagProducts\" as OBP " +
                             "INNER JOIN \"OrderBag\" AS OB ON OBP.\"OrderBag_id\" = OB.\"id\" " +
                             "INNER JOIN \"Product\" AS P ON OBP.\"Product_id\" = P.\"id\" " +
                             "INNER JOIN \"ProductCategory\" AS PC ON P.\"ProductCategory_id\" = PC.\"id\" " +
                             "where OB.\"id\" = ?"
             )) {
            ps.setInt(1, OrderBag_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) orderBagProductsList.add(rsV_dashboard_orderbagproducts(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderBagProductsList;
    }



    //Creates a list of all Orders from database
    @Override
    public List<v_dashboard_order> listCustomerOrders(int Customerid) {
        List<v_dashboard_order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT O.id, O.creationdate, O.additionaltext, O.allergy, O.deliveryaddress, O.deliveryaddresspostalcode, O.deliveryaddresspostaltown, O.invoiceaddress, O.invoiceaddresspostalcode, O.invoiceaddresspostaltown, P.\"name\", C.\"mail\", OS.\"name\" FROM \"Order\" as O " +
                     "INNER JOIN \"Customer\" AS C ON O.\"Customer_id\" = C.\"id\"" +
                     "INNER JOIN \"PaymentMethod\" AS P ON O.\"PaymentMethod_id\" = P.\"id\"" +
                     "INNER JOIN \"OrderStatus\" AS OS ON O.\"OrderStatus_id\" = OS.\"id\"" +
                     "where C.\"id\" = ?")) {
            ps.setInt(1, Customerid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) orderList.add(rsv_dashboard_order(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
