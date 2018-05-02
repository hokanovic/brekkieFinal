package com.example.demo.repository;

import com.example.demo.domain.*;
import com.example.demo.domain.OrderView.OrderView_ContentsOfBag;
import com.example.demo.domain.OrderView.OrderView_ContentsOfCategory;
import com.example.demo.domain.view.*;
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
    //Creates a combined list of Product and ProductCategory
    public List<v_dashboard_product> listProductsWithProductCategory() {
        List<v_dashboard_product> productsWithProductCategoryList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "Select *  from \"Product\" AS P\n" +
                             "INNER JOIN \"ProductCategory\" AS PC\n" +
                             "ON P.\"ProductCategory_id\"=PC.\"id\"\n" +
                             "ORDER BY P.\"id\""
             )) {
            while (rs.next()) productsWithProductCategoryList.add(rsv_dashboard_product(rs));
            return productsWithProductCategoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //Creates a list of all Orders from database
    public List<v_dashboard_order> listOrdersTextP(int Orderid) {
        List<v_dashboard_order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT O.id, O.creationdate, O.additionaltext, O.allergy, O.deliveryaddress, O.deliveryaddresspostalcode, O.deliveryaddresspostaltown, O.invoiceaddress, O.invoiceaddresspostalcode, O.invoiceaddresspostaltown, P.\"name\", C.\"mail\", OS.\"name\" FROM \"Order\" as O " +
                     "INNER JOIN \"Customer\" AS C ON O.\"Customer_id\" = C.\"id\"" +
                     "INNER JOIN \"PaymentMethod\" AS P ON O.\"PaymentMethod_id\" = P.\"id\"" +
                     "INNER JOIN \"OrderStatus\" AS OS ON O.\"OrderStatus_id\" = OS.\"id\"" +
                     "where O.\"id\" = ?")) {
            ps.setInt(1, Orderid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) orderList.add(rsv_dashboard_order(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //Creates a list of all Orders from database
    public List<v_dashboard_order> listOrdersTextPOrderStatus(int OrderStatus) {
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
                     "\"ProductCategory_id\", price FROM \"Product\"")) {
            while (rs.next()) productList.add(rsProduct(rs));
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> listProductsByCatId(int id) {
        List<Product> productList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select id, name, \"ProductCategory_id\", price FROM \"Product\"" +
                     "where \"ProductCategory_id\" = ? order by name ASC")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
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
                     "companyname, contactperson, mail, telephone FROM \"Customer\"")) {
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

    @Override
    public List<ProductCategory> listProductCategoriesByBagId(int id) {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select id, \"name\" from \"ProductCategory\" " +
                     "where id IN (select \"ProductCategory_id\" from \"Bag_ProductCategory\" " +
                     "where \"Bag_id\" = ?) order by name ASC")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
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
             ResultSet rs = stmt.executeQuery("SELECT id, name, price, description FROM \"Bag\" order by id ASC")) {
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
    public void addProduct(String name, int ProductCategory_id,int price) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO \"Product\" (name," +
                     " \"ProductCategory_id\", price) VALUES (?,?,?)")) {
            ps.setString(1, name);
            ps.setInt(2, ProductCategory_id);
            ps.setInt(3,price);

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
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("productCategory_id"),rs.getInt("price"));
    }

    //Creates new Customer from database
    private Customer rsCustomer(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("orgnr"),
                rs.getString("companyname"),
                rs.getString("contactperson"),
                rs.getString("mail"),
                rs.getInt("telephone")
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

    @Override
    public v_dash_orderdetails_order listV_dash_orderdetails_orderWhereOrderidEquals(int Orderid) {
//        private v_dashboard_order v_dashboard_Order;
//        private Customer customer;
//        private List<v_dash_orderdetails_orderbag> orderbagList;

        v_dashboard_order v_dashboard_Order = listOrdersTextPwhereOrderEquals(Orderid).get(0);
        Customer customer = listCustomer(Orderid);
        List<v_dash_orderdetails_orderbag> orderbagList = listOrderBags(Orderid);

        return new v_dash_orderdetails_order(v_dashboard_Order,customer,orderbagList);
    }


    public List<v_dash_orderdetails_orderbag> listOrderBags(int Orderid) {
//        private OrderBag orderbag;
//        private List<OrderBagProducts> orderbagproductsList;

        List<v_dash_orderdetails_orderbag> orderbagList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "select *\n" +
                             "from \"OrderBag\"\n" +
                             "where \"Order_id\" = ?\n" +
                             "Order by \"Bag_id\" ASC"
             )) {
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

    @Override
    public List<OrderView_ContentsOfBag> listContentsOfBag() {

        List<OrderView_ContentsOfBag> listContentsOfBag = new ArrayList<>();

        for (Bag bag : listBags()) {
            List<OrderView_ContentsOfCategory> orderView_ContentsOfCategoryList = new ArrayList<>();
            for (ProductCategory category : listProductCategorys()) {
                OrderView_ContentsOfCategory orderView_contentsOfCategory = new OrderView_ContentsOfCategory(category, listProductsByCatId(category.getId()));
                orderView_ContentsOfCategoryList.add(orderView_contentsOfCategory);
            }
            OrderView_ContentsOfBag orderView_contentsOfBag = new OrderView_ContentsOfBag(bag, orderView_ContentsOfCategoryList);
            listContentsOfBag.add(orderView_contentsOfBag);
        }
        return listContentsOfBag;
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
                     "select OB.\"id\", OB.\"Bag_id\", OB.\"Order_id\", B.\"name\", B.\"price\" " +
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
             PreparedStatement ps = conn.prepareStatement("SELECT id, orgnr, companyname, contactperson, mail, telephone " +
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
                rs.getString(4),
                rs.getDouble(5)
        );
    }

    private v_dashboard_product rsv_dashboard_product(ResultSet rs) throws SQLException {
        return new v_dashboard_product(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(6)
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
    public List<v_dashboard_order> listCustomerOrders(String mail) {
        List<v_dashboard_order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT O.id, O.creationdate, O.additionaltext, O.allergy, O.deliveryaddress, O.deliveryaddresspostalcode, O.deliveryaddresspostaltown, O.invoiceaddress, O.invoiceaddresspostalcode, O.invoiceaddresspostaltown, P.\"name\", C.\"mail\", OS.\"name\" FROM \"Order\" as O " +
                     "INNER JOIN \"Customer\" AS C ON O.\"Customer_id\" = C.\"id\"" +
                     "INNER JOIN \"PaymentMethod\" AS P ON O.\"PaymentMethod_id\" = P.\"id\"" +
                     "INNER JOIN \"OrderStatus\" AS OS ON O.\"OrderStatus_id\" = OS.\"id\"" +
                     "where C.\"mail\" = ?")) {
            ps.setString(1, mail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) orderList.add(rsv_dashboard_order(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrderStatus(int Orderstatus, int Orderid) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE \"Order\" " +
                     "SET \"OrderStatus_id\" = ?" +
                     "WHERE \"id\" = ?")) {
            ps.setInt(1, Orderstatus);
            ps.setInt(2, Orderid);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public List<v_dashboard_order> listOrdersTextPwhereOrderEquals(int Orderid) {
        List<v_dashboard_order> orderList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT O.id, O.creationdate, O.additionaltext, O.allergy, O.deliveryaddress, O.deliveryaddresspostalcode, O.deliveryaddresspostaltown, O.invoiceaddress, O.invoiceaddresspostalcode, O.invoiceaddresspostaltown, P.\"name\", C.\"mail\", OS.\"name\" FROM \"Order\" as O " +
                     "INNER JOIN \"Customer\" AS C ON O.\"Customer_id\" = C.\"id\"" +
                     "INNER JOIN \"PaymentMethod\" AS P ON O.\"PaymentMethod_id\" = P.\"id\"" +
                     "INNER JOIN \"OrderStatus\" AS OS ON O.\"OrderStatus_id\" = OS.\"id\"" +
                     "where O.\"id\" = ?")) {
            ps.setInt(1, Orderid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) orderList.add(rsv_dashboard_order(rs));
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public v_dash_order_stats fetchOrderStats(int Orderid) {
        int totalSum = 0;
        List<Integer> OrderBagsWithPrices = new ArrayList<>();
        List<Integer> OrderBagsWithoutPrices = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "select OB.\"id\", B.\"price\"\n" +
                             "from \"OrderBag\" AS OB\n" +
                             "INNER JOIN \"Bag\" AS B ON OB.\"Bag_id\" = B.\"id\"\n" +
                             "Where OB.\"Order_id\" = ?"
             )) {
            ps.setInt(1, Orderid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getDouble(2) != 0) {
                    OrderBagsWithPrices.add(rs.getInt(1));
                    totalSum += rs.getInt(2);
                } else {
                    OrderBagsWithoutPrices.add(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int orderbagid = 0; orderbagid < OrderBagsWithoutPrices.size(); orderbagid++) {
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                         "select sum(P.\"price\")\n" +
                                 "from \"OrderBagProducts\" AS OBP\n" +
                                 "INNER JOIN \"Product\" AS P ON OBP.\"Product_id\" = P.\"id\"\n" +
                                 "where OBP.\"OrderBag_id\" = ?"
                 )) {
                ps.setInt(1, OrderBagsWithoutPrices.get(orderbagid));
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    totalSum += rs.getDouble(1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return new v_dash_order_stats(totalSum);
    }

    @Override
    public List<v_dash_order_stats_orderbagsum> fetchOrderStats2(int Orderid) {
        List<v_dash_order_stats_orderbagsum> resList = new ArrayList<>();

        List<Integer> OrderBagsWithoutPrices = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "select O.\"Bag_id\", B.\"name\", COUNT(B.\"price\"), SUM(B.\"price\")\n" +
                             "from \"Bag\" AS B\n" +
                             "INNER JOIN \"OrderBag\" AS O ON B.\"id\" = O.\"Bag_id\"\n" +
                             "where O.\"Order_id\" = ?\n" +
                             "GROUP BY O.\"Bag_id\", B.\"name\""
             )) {
            ps.setInt(1, Orderid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(4) != 0) {
                    resList.add(rsFetchOrderStats2(rs));
                } else {
                    OrderBagsWithoutPrices.add(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int orderbagid = 0; orderbagid < OrderBagsWithoutPrices.size(); orderbagid++) {
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                         "select OBP.\"OrderBag_id\", B.\"name\" , count(P.\"id\"), sum(P.\"price\")\n" +
                                 "from \"OrderBagProducts\" AS OBP\n" +
                                 "INNER JOIN \"OrderBag\" AS OB ON OBP.\"OrderBag_id\" = OB.\"id\"\n" +
                                 "INNER JOIN \"Bag\" AS B ON OB.\"Bag_id\" = B.\"id\"\n" +
                                 "INNER JOIN \"Product\" AS P ON OBP.\"Product_id\" = P.\"id\"\n" +
                                 "where OB.\"Order_id\" = ?\n" +
                                 "and OB.\"Bag_id\" = ?\n" +
                                 "GROUP BY OBP.\"OrderBag_id\", B.\"name\""
                 )) {
                ps.setInt(1, Orderid);
                ps.setInt(2, OrderBagsWithoutPrices.get(orderbagid));
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    resList.add(rsFetchOrderStats2(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return resList;
    }

    private v_dash_order_stats_orderbagsum rsFetchOrderStats2(ResultSet rs)  throws SQLException  {
        return new v_dash_order_stats_orderbagsum(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4)
        );
    }

}
