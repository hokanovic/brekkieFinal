package com.example.demo.Controller;

import com.example.demo.domain.ConfirmOrder;
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
        String subject = "En ny beställning!";
        String text = " En testbeställning från Team Brekkie: \n" + " " + orderForm.getCompanyName() + " " +
                orderForm.getOrgNr() + "\n " + orderForm.getContactperson() + " " + orderForm.getPhoneNumber() + " " +
                orderForm.getEmail() + "\n " + orderForm.getInvoiceAddress() + " " + orderForm.getInvoicePostalTown() +
                " " + orderForm.getInvoicePostNumber() + "\n " + orderForm.getDeliveryAddress() + " " +
                orderForm.getDeliveryPostalTown() + " " + orderForm.getDeliveryPostNumber() + "\n " +
                orderForm.getAllergy() + " " + orderForm.getAllergyMarking() + "\n " + orderForm.getDeliveryDate() +
                " " + orderForm.getDeliveryTime();

        emailService.sendSimpleMessage(to, subject, text);

        return "";
    }

    public String confirmOrder() {

        String to = "slutprojektacademy@gmail.com";
        String subject = "Din frukostbeställning behandlas!";
        String text = " En testbekräftelse från Brekkiegänget. Vi gör just nu en låtsasfrukost enligt Er beställning :)";

        emailService.sendSimpleMessage(to, subject, text);

        return "";
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
