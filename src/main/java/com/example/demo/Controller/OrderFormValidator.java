package com.example.demo.Controller;

import com.example.demo.domain.OrderForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Calendar;

public class OrderFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {

        return OrderForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderForm orderForm = (OrderForm) target;
        Date today = new Date( new java.util.Date().getTime() );
        Date tomorrow= new Date( today.getTime() + 24*60*60*1000);
        if (orderForm.getDeliveryDate().compareTo(today) < 0) {
            errors.rejectValue("deliveryDate", "felaktigt datum");
        }
//        if (!orderForm.getPhoneNumber().matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4}|^\\(?(\\d{2})\\)?[- ]?(\\d{8})l)$") ||
//                !orderForm.getPhoneNumber().matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4}|^\\(?(\\d{2})\\)?[- ]?(\\d{8})l)$")) {
//            errors.rejectValue("phoneNumber", "felaktigt telefonnummer");
//        }
//        if (!orderForm.getDeliveryPostNumber().matches("(\\d{3}[ ]?\\d{2})") ||
//                !orderForm.getDeliveryPostNumber().matches("(\\d{5})")) {
//            errors.rejectValue("deliveryPostNumber", "felaktigt postnummer");
//        }
//        if (!orderForm.getInvoicePostNumber().matches("(\\d{3}[ ]?\\d{2})") ||
//                !orderForm.getDeliveryPostNumber().matches("(\\d{5})")) {
//            errors.rejectValue("invoicePostNumber", "felaktigt postnummer");
//        }
        if (orderForm.getAllergy()==null || (orderForm.getAllergy() && (orderForm.getAllergyMarking() == null || orderForm.getAllergyMarking() ==""))){
            errors.rejectValue("allergy", "Vänligen ange allergier");

        }
       // if (orderForm.getDeliveryDate() == tomorrow && )

    }
}
