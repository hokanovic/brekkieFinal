package com.example.demo.domain;

public class Customer {
    private int id;
    private String orgnr;
    private String companyname;
    private String contactperson;
    private String mail;

    public Customer(int id, String orgnr, String companyname, String contactperson, String mail) {
        this.id = id;
        this.orgnr = orgnr;
        this.companyname = companyname;
        this.contactperson = contactperson;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgnr() {
        return orgnr;
    }

    public void setOrgnr(String orgnr) {
        this.orgnr = orgnr;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}