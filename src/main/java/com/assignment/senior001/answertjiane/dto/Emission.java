package com.assignment.senior001.answertjiane.dto;

public class Emission {

    private String amount;
    private String emissionSource;
    private String comments;
    private String monthRecorded;

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

    @Override
    public String toString() {
        return "Emission{" +
                "amount='" + amount + '\'' +
                ", emissionSource='" + emissionSource + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
