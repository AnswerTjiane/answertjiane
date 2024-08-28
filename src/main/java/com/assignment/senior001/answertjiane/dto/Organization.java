package com.assignment.senior001.answertjiane.dto;

import java.util.List;

public class Organization {

    private String organizationName;
    private List<Office> offices;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
