package com.example.demo.Controller;

import com.example.demo.domain.Bag;
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
import java.util.Calendar;
import java.util.List;


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

    //Beginning of "Lecoq ändringar"
    @GetMapping("/alternativ")
    public ModelAndView seeBreakfastAlternatives() {
        List<Bag> bagList;
        bagList = shopRepository.listBags();
        return new ModelAndView("displayBags").addObject("BreakfastBag", bagList);
    }

    //HÅRDKÅDAT PLEASE DO REFACTOR!
    @GetMapping("/breakfastBag")
    public ModelAndView seeYourBreakfastBag(@RequestParam int id){
        List<Bag> bagList;
        bagList = shopRepository.listBagById(id);
        Bag bag = bagList.get(0);
        return new ModelAndView("breakfastBag").addObject("bag", bag);
    }

    /*@RequestMapping("/breakfastBag")
    public ModelAndView seeChosenBreakfastBag(@RequestParam int id){
        List<Bag> bagList;
        bagList = shopRepository.listBagById(id);
        Bag bag = bagList.get(0);
        ModelAndView modelAndView = new ModelAndView("bag");
        modelAndView.addObject("bag", bag);
        return modelAndView;
    }*/
    //HÅRDKÅDAT PLEASE DO REFACTOR!
    //End of "Lecoq ändringar"

    @PostMapping("/frukost")
    public String submitOrder(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            emailService.sendMail(orderForm);
            if (bindingResult.hasErrors()) {
                return "orderForm";
            } else {
                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

                //OBS - PaymentMethod, Customer_ID!!!
                shopRepository.addOrder(date, orderForm.getAdditionalText(), orderForm.getAllergyMarking(), orderForm.getDeliveryAddress(),
                        orderForm.getDeliveryPostNumber(), orderForm.getDeliveryPostalTown(), orderForm.getInvoiceAddress(),
                        orderForm.getInvoicePostNumber(), orderForm.getInvoicePostalTown(), 1, 2,2);
                // OBS ID
                shopRepository.addCustomer(orderForm.getOrgNr(), orderForm.getCompanyName(), orderForm.getContactperson(), orderForm.getEmail());
            }
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
                .addObject("Orders", shopRepository.listV_dash_orderdetails_order(Orderid));
    }
}
