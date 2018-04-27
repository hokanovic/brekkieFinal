package com.example.demo.Controller;

import com.example.demo.domain.OrderForm;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;


@Controller
public class brekkieController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private EmailController emailService;

    @GetMapping("/frukost")
    public ModelAndView orderBreakfast(){
        return new ModelAndView("orderForm").addObject("orderForm", new OrderForm());
    }

    @GetMapping("/alternativ")
    public ModelAndView seeBreakfastAlternatives() {
        return new ModelAndView("displayBags").addObject("BreakfastBag", shopRepository.listBags());
    }

    @PostMapping("/frukost")
    public String submitOrder(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            emailService.sendMail(orderForm);
        }
        if (bindingResult.hasErrors()) {
            return "orderForm";
        } else {
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

            //OBS - PaymentMethod, Customer_ID!!!
            shopRepository.addOrder(134, date, orderForm.getAdditionalText(), orderForm.getAllergyMarking(), orderForm.getDeliveryAdress(),
                    orderForm.getDeliveryPostNumber(), orderForm.getDeliveryPostalTown(), orderForm.getInvoiceAdress(),
                    orderForm.getInvoicePostNumber(), orderForm.getInvoicePostalTown(), 1, 2);
            // OBS ID
            shopRepository.addCustomer(134, orderForm.getOrgId(), orderForm.getCompanyName(), orderForm.getReference(), orderForm.getEmail());
            return "thankyou";
        }
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

}
