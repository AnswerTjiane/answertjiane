package com.assignment.senior001.answertjiane.dto;

import java.util.List;

public class Office {

    private String officeName;
    private String installedSolarPower;
    private List<Emission> emissions;

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getInstalledSolarPower() {
        return installedSolarPower;
    }

    public void setInstalledSolarPower(String installedSolarPower) {
        this.installedSolarPower = installedSolarPower;
    }

    public List<Emission> getEmissions() {
        return emissions;
    }

    public void setEmissions(List<Emission> emissions) {
        this.emissions = emissions;
    }
}
