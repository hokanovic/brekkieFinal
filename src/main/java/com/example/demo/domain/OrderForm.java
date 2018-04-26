package com.example.demo.domain;

import com.example.demo.Controller.EmailController;

import javax.validation.constraints.*;
import java.sql.Date;
import java.sql.Time;

public class OrderForm {



    @NotNull(message = "Måste anges")
    @NotEmpty(message = "Måste anges")
    @Size(min=2, max=50, message = "Företagsnamnet måste bestå av minst 2 tecken")
    private String companyName = "";

    private String orgId;
    @NotNull(message = "Måste anges")
    @Size(min=2, max=30)
    private String reference;
    //@Digits(message = "Ange ett giltigt telefonnummer")
    private String phoneNumber;
    @NotNull(message = "Måste anges")
    @Email
    private String email;
    private String invoiceAdress;
    private String invoicePostalTown;
    private String invoicePostNumber;
    @NotNull(message = "Måste anges")
    private String deliveryAdress;
    @NotNull
    private String deliveryPostalTown;
    @NotNull(message = "Måste anges")
    //@Digits(message = "Ange ett giltigt postnummer")
    @Size(min=5, max=6, message = "Ange ett giltigt postnummer")
    private String deliveryPostNumber;
    @NotNull(message = "Måste klicka i om allergier förekommer")
    private boolean allergy;

    private String allergymarking;

    private Date deliveryDate;

    private Time deliveryTime;

    public OrderForm() {
    }

    public OrderForm(String companyName, String orgId,
                     String reference, String phoneNumber,
                     String email, String invoiceAdress,
                     String invoicePostalTown, String invoicePostNumber,
                     String deliveryAdress, String deliveryPostalTown,
                     String deliveryPostNumber, boolean allergy, String allergymarking,
                     Date deliveryDate, Time deliveryTime) {
        this.companyName = companyName;
        this.orgId = orgId;
        this.reference = reference;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.invoiceAdress = invoiceAdress;
        this.invoicePostalTown = invoicePostalTown;
        this.invoicePostNumber = invoicePostNumber;
        this.deliveryAdress = deliveryAdress;
        this.deliveryPostalTown = deliveryPostalTown;
        this.deliveryPostNumber = deliveryPostNumber;
        this.allergy = allergy;
        this.allergymarking = allergymarking;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvoiceAdress() {
        return invoiceAdress;
    }

    public void setInvoiceAdress(String invoiceAdress) {
        this.invoiceAdress = invoiceAdress;
    }

    public String getInvoicePostalTown() {
        return invoicePostalTown;
    }

    public void setInvoicePostalTown(String invoicePostalTown) {
        this.invoicePostalTown = invoicePostalTown;
    }

    public String getInvoicePostNumber() {
        return invoicePostNumber;
    }

    public void setInvoicePostNumber(String invoicePostNumber) {
        this.invoicePostNumber = invoicePostNumber;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public String getDeliveryPostalTown() {
        return deliveryPostalTown;
    }

    public void setDeliveryPostalTown(String deliveryPostalTown) {
        this.deliveryPostalTown = deliveryPostalTown;
    }

    public String getDeliveryPostNumber() {
        return deliveryPostNumber;
    }

    public void setDeliveryPostNumber(String deliveryPostNumber) {
        this.deliveryPostNumber = deliveryPostNumber;
    }

    public boolean isAllergy() {
        return allergy;
    }

    public void setAllergy(boolean allergy) {
        this.allergy = allergy;
    }

    public String getAllergymarking() {
        return allergymarking;
    }

    public void setAllergymarking(String allergymarking) {
        this.allergymarking = allergymarking;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Time getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
