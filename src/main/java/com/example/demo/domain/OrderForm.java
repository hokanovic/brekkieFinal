package com.example.demo.domain;

import com.example.demo.Controller.EmailController;

import javax.validation.constraints.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class OrderForm {


    @NotEmpty
    @Size(min=2, max=50)
    private String companyName;

    @NotEmpty
    private String orgNr;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String contactperson;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String invoiceAddress;

    @NotEmpty
    private String invoicePostalTown;

    @NotEmpty
    private String invoicePostNumber;

    @NotEmpty
    private String deliveryAddress;

    @NotEmpty
    private String deliveryPostalTown;

    @NotEmpty
    private String deliveryPostNumber;

    @NotNull
    private Boolean allergy;

    private String allergyMarking;

    @NotNull
    private Date deliveryDate;

    @NotNull
    private LocalTime deliveryTime;

    private String additionalText;

    private Double lat;
    private Double lng;

    public OrderForm(@NotEmpty @Size(min = 2, max = 50) String companyName, @NotEmpty String orgNr, @NotEmpty @Size(min = 2, max = 30) String contactperson, @NotEmpty String phoneNumber, @NotEmpty @Email String email, @NotEmpty String invoiceAddress, @NotEmpty String invoicePostalTown, @NotEmpty String invoicePostNumber, @NotEmpty String deliveryAddress, @NotEmpty String deliveryPostalTown, @NotEmpty String deliveryPostNumber, @NotNull Boolean allergy, String allergyMarking, @NotNull Date deliveryDate, @NotNull LocalTime deliveryTime, String additionalText, Double lat, Double lng) {
        this.companyName = companyName;
        this.orgNr = orgNr;
        this.contactperson = contactperson;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.invoiceAddress = invoiceAddress;
        this.invoicePostalTown = invoicePostalTown;
        this.invoicePostNumber = invoicePostNumber;
        this.deliveryAddress = deliveryAddress;
        this.deliveryPostalTown = deliveryPostalTown;
        this.deliveryPostNumber = deliveryPostNumber;
        this.allergy = allergy;
        this.allergyMarking = allergyMarking;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.additionalText = additionalText;
        this.lat = lat;
        this.lng = lng;
    }

    public OrderForm() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrgNr() {
        return orgNr;
    }

    public void setOrgNr(String orgNr) {
        this.orgNr = orgNr;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
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

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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

    public Boolean getAllergy() {
        return allergy;
    }

    public void setAllergy(Boolean allergy) {
        this.allergy = allergy;
    }

    public String getAllergyMarking() {
        return allergyMarking;
    }

    public void setAllergyMarking(String allergymarking) {
        this.allergyMarking = allergymarking;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }
}
