package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    public EmailService emailService;

    @GetMapping("/")
    public String sendMail() {

        String to = "slutprojektacademy@gmail.com";
        String subject = "Move along..nothing to see here..";
        String text = "Oskar says hello";

        emailService.sendSimpleMessage(to, subject, text);

        return "Your mail has taken off!";
    }

    @GetMapping("/template")
    public String sendTemplateMail() {

        String to = "slutprojektacademy@gmail.com";
        String subject = "jag är bara ett testmail";
        String name = "Oskar says hello";

        emailService.sendTemplateMessage(to, subject, name);

        return "Your mail has taken off!";
    }


}
