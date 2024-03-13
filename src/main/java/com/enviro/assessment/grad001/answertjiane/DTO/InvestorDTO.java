package com.enviro.assessment.grad001.answertjiane.DTO;

import jakarta.persistence.Column;

import java.sql.Date;
import java.util.List;

public class InvestorDTO {

    private String name;
    private String surname;
    private String contactNumber;
    private Date createdAt;
    private Date updatedAt;
    private String AddressLine1;
    private String AddressLine2;
    private String AddressSuburb;
    private String AddressCity;
    private String postalCode;
    private List<ProductDTO> products;

    public InvestorDTO() {
    }

    public InvestorDTO(String name, String surname, String contactNumber, Date createdAt, Date updatedAt, String addressLine1, String addressLine2, String addressSuburb, String addressCity, String postalCode, List<ProductDTO> products) {
        this.name = name;
        this.surname = surname;
        this.contactNumber = contactNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        AddressLine1 = addressLine1;
        AddressLine2 = addressLine2;
        AddressSuburb = addressSuburb;
        AddressCity = addressCity;
        this.postalCode = postalCode;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getAddressSuburb() {
        return AddressSuburb;
    }

    public void setAddressSuburb(String addressSuburb) {
        AddressSuburb = addressSuburb;
    }

    public String getAddressCity() {
        return AddressCity;
    }

    public void setAddressCity(String addressCity) {
        AddressCity = addressCity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
