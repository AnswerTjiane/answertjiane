package com.assignment.senior001.answertjiane.service;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dao.OfficeEntity;
import com.assignment.senior001.answertjiane.dto.Emission;

import java.util.List;

public interface EmissionService {

    String createEmission(Emission emission, String officeName);
    List<Emission> getAllEmissions();
    List<Emission> getEmissionsByOffice(String officeName);
    List<Emission> getEmissionsBySource(String emissionSource);
    double calculateTotalEmissionsForOffice(String officeName);
    double calculateAverageEmissionsForSource(String emissionSource);
    double calculateTotalEmissions();
}
