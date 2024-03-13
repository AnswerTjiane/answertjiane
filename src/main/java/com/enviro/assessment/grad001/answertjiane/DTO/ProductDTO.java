package com.enviro.assessment.grad001.answertjiane.DTO;

import java.sql.Date;

public class ProductDTO {

    private Long id;
    private String productType;
    private Double balance;
    private Date createdAt;
    private Date updatedAt;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String productType, Double balance, Date createdAt, Date updatedAt) {
        this.id = id;
        this.productType = productType;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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
}
