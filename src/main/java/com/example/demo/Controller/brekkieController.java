package com.example.demo.Controller;

import com.example.demo.domain.OrderForm;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Calendar;


@Controller
public class brekkieController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private EmailController emailService;

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


    @GetMapping("/dashboardOrders")
    public ModelAndView brekkiedashboardOrders() {
        return new ModelAndView("dashboardOrders").addObject("Orders", shopRepository.listOrders());
    }


    @GetMapping("/dashboardOrdersText")
    public ModelAndView brekkiedashboardOrdersText() {
        return new ModelAndView("dashboardOrdersText")
                .addObject("Orders", shopRepository.listOrdersText())
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }



    @GetMapping("/dashboardOrdersTextP")
    public ModelAndView brekkiedashboardOrdersTextP(@RequestParam int OrderStatus) {
        return new ModelAndView("dashboardOrdersText")
                .addObject("Orders", shopRepository.listOrdersTextP(OrderStatus))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());

        //return new ModelAndView("dashboardOrdersText").addObject("Orders", shopRepository.listOrdersText());

    }

    @GetMapping("/dashboardCustomers")
    public ModelAndView brekkiedashboardCustomers() {
        return new ModelAndView("dashboardCustomers").addObject("Customers", shopRepository.listCustomers());
    }

    @GetMapping("/dashboardOrderDetails")
    public ModelAndView brekkiedashboardOrderDetails(@RequestParam int Orderid) {
        return new ModelAndView("dashboardOrderDetails")
                .addObject("Orders", shopRepository.listV_dash_orderdetails_order(Orderid))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }

    @GetMapping("/dashboardCustomerOrders")
    public ModelAndView brekkiedashboardCustomerOrders(@RequestParam String Customermail) {
        return new ModelAndView("dashboardCustomerOrders")
                .addObject("Orders", shopRepository.listCustomerOrders(Customermail))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }

    @GetMapping("/dashboardOrderDetailsUpdate")
    public ModelAndView OrderDetailsChangeOrderStatus(@RequestParam int Orderstatus, @RequestParam int Orderid) {

        shopRepository.updateOrderStatus(Orderstatus, Orderid);

        return new ModelAndView("dashboardOrderDetails")
                .addObject("Orders", shopRepository.listV_dash_orderdetails_orderWhereOrderidEquals(Orderid))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }


    @GetMapping("/dashboardOrdersTextUpdateOrderStatus")
    public ModelAndView brekkiedashboardOrdersTextUpdateOrderStatus(@RequestParam int Orderstatus, @RequestParam int Orderid) {
        shopRepository.updateOrderStatus(Orderstatus, Orderid);

        return new ModelAndView("dashboardOrdersText")
                .addObject("Orders", shopRepository.listOrdersText())
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());
    }


    @GetMapping("/dashboardOrdersTextPUpdateOrderStatus")
    public ModelAndView brekkiedashboardOrdersTextPUpdateOrderStatus(@RequestParam int Orderstatus, @RequestParam int Orderid) {

        shopRepository.updateOrderStatus(Orderstatus, Orderid);

        return new ModelAndView("dashboardOrdersText")
                .addObject("Orders", shopRepository.listOrdersTextP(Orderstatus))
                .addObject("OrderStatuses", shopRepository.listOrderStatuses());

        //return new ModelAndView("dashboardOrdersText").addObject("Orders", shopRepository.listOrdersText());

    }
}
