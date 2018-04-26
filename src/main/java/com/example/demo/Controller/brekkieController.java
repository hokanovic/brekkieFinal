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


    @GetMapping("/frukost")
    public ModelAndView orderBreakfast(){
        return new ModelAndView("orderForm").addObject("orderForm", new OrderForm());
    }

    @GetMapping("/alternativ")
    public ModelAndView seeBreakfastAlternatives(){
        return new ModelAndView("displayBags").addObject("BreakfastBag", shopRepository.listBags());
    }

    @PostMapping("/frukost")
    public String checkPersonInfo(@Valid OrderForm orderForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "orderForm";
        }
        else
            return "thankyou";
    }

    @GetMapping("/dashboardOrders")
    public ModelAndView brekkiedashboardOrders(){



        Order2 order1 = new Order2(1,1,"2018-02-02","1",false,"additionaltext","2018-08-08",LocalDate.of(2012, Month.DECEMBER, 12), LocalTime.of(12,13,14));
        Order2 order2 = new Order2(1,1,"2018-02-02","1",false,"additionaltext","2018-08-08",LocalDate.of(2012, Month.DECEMBER, 12), LocalTime.of(12,13,14));
        Order2 order3 = new Order2(1,1,"2018-02-02","1",false,"additionaltext","2018-08-08",LocalDate.of(2012, Month.DECEMBER, 12), LocalTime.of(12,13,14));
        List<Order2> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

//        return new ModelAndView("dashboardOrders").addObject("Orders", shopRepository.listOrders());
        return new ModelAndView("dashboardOrders").addObject("Orders", orderList);
    }
}
