package com.assignment.senior001.answertjiane.service;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dao.OfficeEntity;
import com.assignment.senior001.answertjiane.dto.Emission;
import com.assignment.senior001.answertjiane.helper.ObjectMapper;
import com.assignment.senior001.answertjiane.repository.EmissionRepository;
import com.assignment.senior001.answertjiane.repository.OfficeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmissionServiceImpl implements EmissionService {

    private EmissionRepository emissionRepository;
    private OfficeRepository officeRepository;
    private final ObjectMapper objectMapper;

    public EmissionServiceImpl(EmissionRepository emissionRepository, OfficeRepository officeRepository, ObjectMapper objectMapper) {
        this.emissionRepository = emissionRepository;
        this.objectMapper = objectMapper;
        this.officeRepository = officeRepository;
    }

    @Override
    public String createEmission(Emission emission, String officeName) {
        Optional<OfficeEntity> office = officeRepository.findByOfficeName(officeName);
        if (office.isPresent()) {
            EmissionEntity emissionEntity = objectMapper.toEmissionEntity(emission);
            emissionEntity.setOfficeEntity(office.orElse(null));
            objectMapper.toEmissionDTO(emissionRepository.save(emissionEntity));
            return "Created";
        }else {
            return "office name not found";
        }
    }

    @Override
    public List<Emission> getAllEmissions() {
        return transformList(emissionRepository.findAll());
    }

    @Override
    public List<Emission> getEmissionsByOffice(String officeName) {
        OfficeEntity officeEntity = officeRepository.findByOfficeName(officeName).orElse(null);
        return transformList(emissionRepository.findByOfficeEntity(officeEntity));
    }

    @Override
    public List<Emission> getEmissionsBySource(String emissionSource) {
        return transformList(emissionRepository.findByEmissionSource(emissionSource));
    }

    @Override
    public double calculateTotalEmissionsForOffice(String officeName) {
        OfficeEntity officeEntity = officeRepository.findByOfficeName(officeName).orElse(null);
        return emissionRepository.findByOfficeEntity(officeEntity).stream()
                .mapToDouble(e -> Double.parseDouble(e.getAmount()))
                .sum();
    }

    @Override
    public double calculateAverageEmissionsForSource(String emissionSource) {
        List<EmissionEntity> emissions = emissionRepository.findByEmissionSource(emissionSource);
        return emissions.stream()
                .mapToDouble(e -> Double.parseDouble(e.getAmount()))
                .average()
                .orElse(0.0);
    }

    @Override
    public double calculateTotalEmissions() {
        return emissionRepository.findAll().stream()
                .mapToDouble(e -> Double.parseDouble(e.getAmount()))
                .sum();
    }

    private List<Emission> transformList(List<EmissionEntity> emissionEntityList){
        List<Emission> emissionList = new ArrayList<>();
        for (EmissionEntity em: emissionEntityList){
            emissionList.add(objectMapper.toEmissionDTO(em));
        }
        return emissionList;
    }
}
