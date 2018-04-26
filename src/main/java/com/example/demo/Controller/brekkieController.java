package com.example.demo.Controller;

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
    public ModelAndView dashboardOrders(){
        return new ModelAndView("dashboardOrders");
    }
}
