package com.example.demo.Controller;

import com.example.demo.Cart;
import com.example.demo.domain.JsonOrder;
import com.example.demo.domain.OrderForm;
import com.example.demo.domain.view.v_dash_order_stats_orderbagsum;
import com.example.demo.domain.Product;
import com.example.demo.domain.ProductCategory;
import com.example.demo.repository.ShopRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Controller
public class brekkieController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private EmailController emailService;

    @PostMapping(value = "/frukost", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String jsonCart(@RequestBody ArrayList<JsonOrder> jsonOrders) {
        System.out.println(jsonOrders.get(0).getProductName() + jsonOrders.get(0).getBagId() + " " + jsonOrders.get(0).getProductId() + " " + jsonOrders.get(0).getProductQty());
//        for (JsonOrder jsonOrder : cart) {
//            System.out.println(jsonOrder.getBagId() + " " + jsonOrder.getProductId() + " " + jsonOrder.getProductQty());
//        }
        return "success";
    }

    @GetMapping("/frukost")
    public ModelAndView orderBreakfast() {
        return new ModelAndView("orderForm").addObject("orderForm", new OrderForm());
    }

    @GetMapping("/order")
    public ModelAndView seeBreakfastAlternatives() {
        return new ModelAndView("order").addObject("BagCategoryProduct", shopRepository.listContentsOfBag());
    }

    @PostMapping("/frukost")
    public String submitOrder(@ModelAttribute OrderForm orderForm, BindingResult bindingResult) {
        OrderFormValidator orderFormValidator = new OrderFormValidator();

        if (orderFormValidator.supports(orderForm.getClass())) {
            orderFormValidator.validate(orderForm, bindingResult);
        }
        if (bindingResult.hasErrors()) {
            return "orderForm";
        } else {
            emailService.sendMail(orderForm);
            Date date = new Date(Calendar.getInstance().getTime().getTime());

            //OBS - Customer_ID!!!
            shopRepository.addOrder(date, orderForm.getAdditionalText(), orderForm.getAllergyMarking(), orderForm.getDeliveryAddress(),
                    orderForm.getDeliveryPostNumber(), orderForm.getDeliveryPostalTown(), orderForm.getInvoiceAddress(),
                    orderForm.getInvoicePostNumber(), orderForm.getInvoicePostalTown(), 1, 2, 2);

            shopRepository.addCustomer(orderForm.getOrgNr(), orderForm.getCompanyName(), orderForm.getContactperson(), orderForm.getEmail());
        }

        return "thankyou";
    }


    @GetMapping("/dashboardOrdersText")
    public ModelAndView brekkiedashboardOrdersText() {
        return new ModelAndView("dashboardOrdersText")
                .addObject("Orders", shopRepository.listOrdersTextPOrderStatus(2))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }



    @GetMapping("/dashboardOrdersTextP")
    public ModelAndView brekkiedashboardOrdersTextP(@RequestParam int OrderStatus) {
        return new ModelAndView("dashboardOrdersText")
                .addObject("CurrentOrderStatus",OrderStatus)
                .addObject("Orders", shopRepository.listOrdersTextPOrderStatus(OrderStatus))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());

        //return new ModelAndView("dashboardOrdersText").addObject("Orders", shopRepository.listOrdersText());

    }

    @GetMapping("/dashboardCustomers")
    public ModelAndView brekkiedashboardCustomers() {
        return new ModelAndView("dashboardCustomers").addObject("Customers", shopRepository.listCustomers());
    }


    @GetMapping("/dashboardProducts")
    public ModelAndView brekkiedashboardProducts() {
        return new ModelAndView("dashboardProducts").addObject("Products", shopRepository.listProducts())
                .addObject("ProductCategory", shopRepository.listProductCategorys())
                .addObject("ProductAndProductCategoryName",shopRepository.listProductsWithProductCategory());
    }

    @GetMapping("/dashboardaddProductCategory")
    public ModelAndView brekkiedashboardaddProductCategory() {
        return new ModelAndView("dashboardaddProductCategory")
                .addObject("productcategory",new ProductCategory())
                .addObject("productcategorylist",shopRepository.listProductCategorys());
    }

    @PostMapping("dashboardaddProductCategory")
    public ModelAndView addProductCategory(@ModelAttribute ProductCategory productcategory) {
        shopRepository.addProductCategory(productcategory.getName());
        return new ModelAndView("dashboardaddProductCategory")
                .addObject("productcategory",new ProductCategory())
                .addObject("productcategorylist",shopRepository.listProductCategorys());
    }


    @GetMapping("/dashboardaddProducts")
    public ModelAndView brekkiedashboardaddProducts() {
        return new ModelAndView("dashboardaddProducts")
                .addObject("product",new Product())
                .addObject("ProductCategory", shopRepository.listProductCategorys());
    }

    @PostMapping("dashboardaddProducts")
    public ModelAndView addProduct(@ModelAttribute Product product) {
        shopRepository.addProduct(product.getName(),product.getProductCategory_id(),product.getPrice());
        return new ModelAndView("dashboardaddProducts")
                .addObject("product",new Product())
                .addObject("ProductCategory", shopRepository.listProductCategorys());
    }


    //visa detaljer för specifik order,
    //inparameter Orderid
    @GetMapping("/dashboardOrderDetails")
    public ModelAndView brekkiedashboardOrderDetails(@RequestParam int Orderid) {

        List<v_dash_order_stats_orderbagsum> resList = shopRepository.fetchOrderStats2(Orderid);
        int orderTotalSum = 0;
        for (v_dash_order_stats_orderbagsum v_dash_order_stats_orderbagsum : resList) {
            orderTotalSum += v_dash_order_stats_orderbagsum.getSum();
        }

        return new ModelAndView("dashboardOrderDetails")
                .addObject("Orders", shopRepository.listV_dash_orderdetails_order(Orderid))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses())
                .addObject("statList", resList)
                .addObject("orderTotalSum", orderTotalSum);
    }

    //Lista Orders Efter kundmail
    @GetMapping("/dashboardCustomerOrders")
    public ModelAndView brekkiedashboardCustomerOrders(@RequestParam String Customermail) {
        return new ModelAndView("dashboardCustomerOrders")
                .addObject("Orders", shopRepository.listCustomerOrders(Customermail))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }

    //inne på en orders orderdetaljer, behöver ny orderstatus
    //ändra i sql och visa samma vy för samma orderid
    @GetMapping("/dashboardOrderDetailsUpdate")
    public ModelAndView OrderDetailsChangeOrderStatus(@RequestParam int Orderstatus, @RequestParam int Orderid) {

        shopRepository.updateOrderStatus(Orderstatus, Orderid);

        return new ModelAndView("dashboardOrderDetails")
                .addObject("Orders", shopRepository.listV_dash_orderdetails_orderWhereOrderidEquals(Orderid))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }








    @GetMapping("/dashboardOrdersTextPUpdateOrderStatus")
    public ModelAndView brekkiedashboardOrdersTextPUpdateOrderStatus(@RequestParam int Orderstatus, @RequestParam int Orderid,@RequestParam int showOrderStatus) {

        shopRepository.updateOrderStatus(Orderstatus, Orderid);

        return new ModelAndView("dashboardOrdersText")
                .addObject("CurrentOrderStatus",showOrderStatus)
                .addObject("Orders", shopRepository.listOrdersTextPOrderStatus(showOrderStatus))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());

        //return new ModelAndView("dashboardOrdersText").addObject("Orders", shopRepository.listOrdersText());

    }



    @GetMapping("/dashboardDashboard")
    public ModelAndView brekkiedashboardDashboard(@RequestParam int Orderid) {



        return new ModelAndView("dashboardDashboard")
                .addObject("statList", shopRepository.fetchOrderStats2(Orderid));
    }

    @GetMapping("/error")
    public ModelAndView brekkieError() {
        return new ModelAndView("error");
    }
}
