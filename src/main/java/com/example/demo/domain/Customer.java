package com.example.demo.domain;

public class Customer {
    private int id;
    private String companyName;
    private String email;
    private String orgId;
    private String reference;
    private String phoneNumber;
    private String invoiceAdress;
    private String invoicePostalTown;
    private String invoicePostNumber;
    private String deliveryAdress;
    private String deliveryPostalTown;
    private String deliveryPostNumber;


    public Customer(int id, String companyName, String orgId, String reference,
                    String phoneNumber, String email, String invoiceAdress,
                    String invoicePostalTown, String invoicePostNumber, String deliveryAdress,
                    String deliveryPostalTown, String deliveryPostNumber) {
        this.id = id;
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}