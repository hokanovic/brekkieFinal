package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class brekkieController {


    @GetMapping("/frukost")
    public ModelAndView orderBreakfast(){
        return new ModelAndView("orderForm");
    }

    @GetMapping("/alternativ")
    public ModelAndView seeBreakfastAlternatives(){
        return new ModelAndView("displayBags");
    }
}
