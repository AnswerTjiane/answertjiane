package com.assignment.senior001.answertjiane.dao;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "emission")
public class EmissionEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private OfficeEntity officeEntity;

    private String amount;
    private String emissionSource;
    private String comments;
    private String monthRecorded;


    public OfficeEntity getOffice() {
        return officeEntity;
    }

    public void setOffice(OfficeEntity officeEntity) {
        this.officeEntity = officeEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OfficeEntity getOfficeEntity() {
        return officeEntity;
    }

    public void setOfficeEntity(OfficeEntity officeEntity) {
        this.officeEntity = officeEntity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmissionSource() {
        return emissionSource;
    }

    public void setEmissionSource(String emissionSource) {
        this.emissionSource = emissionSource;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMonthRecorded() {
        return monthRecorded;
    }

    public void setMonthRecorded(String monthRecorded) {
        this.monthRecorded = monthRecorded;
    }
}