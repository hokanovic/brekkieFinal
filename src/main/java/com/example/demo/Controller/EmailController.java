package com.example.demo.Controller;

import com.example.demo.domain.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
public class EmailController {

    @Autowired
    public EmailService emailService;

    public String sendMail(OrderForm orderForm) {

        String to = "slutprojektacademy@gmail.com";
        String subject = "Move along..nothing to see here..";
        String text = "Oskar says hello" + " " + orderForm.getCompanyName() + orderForm.getInvoiceAdress();

        emailService.sendSimpleMessage(to, subject, text);

        return "Your mail has taken off!";
    }
/*
    @GetMapping("/mailtemplate")
    public String sendTemplateMail() {

        String to = "slutprojektacademy@gmail.com";
        String subject = "jag är bara ett testmail";
        String name = "Oskar in template";

        emailService.sendTemplateMessage(to, subject, name);

        return "Your mail has taken off!";
    }
    */


}
