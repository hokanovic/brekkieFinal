package com.example.demo.Controller;

import com.example.demo.domain.Order;
import com.example.demo.domain.Order2;
import com.example.demo.domain.OrderForm;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
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
        shopRepository.addBag(5,"Katt",150);
        return new ModelAndView("orderForm").addObject("orderForm", new OrderForm());
    }

    @GetMapping("/alternativ")
    public ModelAndView seeBreakfastAlternatives(){
        return new ModelAndView("displayBags").addObject("BreakfastBag", shopRepository.listBags());
    }

    @PostMapping("/frukost")
    public String checkPersonInfo(@Valid OrderForm orderForm, BindingResult bindingResult, Model model) {

        emailService.sendMail(orderForm);
        if (bindingResult.hasErrors()){
            return "orderForm";
        }
        else
            return "thankyou";
    }

    @GetMapping("/dashboardOrders")
    public ModelAndView brekkiedashboardOrders(){

        return new ModelAndView("dashboardOrders").addObject("Orders", shopRepository.listOrders());
    }

    @GetMapping("/dashboardOrdersText")
    public ModelAndView brekkiedashboardOrdersText(){
        return new ModelAndView("dashboardOrdersText").addObject("Orders", shopRepository.listOrdersText());
    }
}
