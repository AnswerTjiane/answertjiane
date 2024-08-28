package com.assignment.senior001.answertjiane.service;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dao.OfficeEntity;
import com.assignment.senior001.answertjiane.dao.OrganizationEntity;
import com.assignment.senior001.answertjiane.dto.EmissionSource;
import com.assignment.senior001.answertjiane.dto.Office;
import com.assignment.senior001.answertjiane.dto.Organization;
import com.assignment.senior001.answertjiane.helper.ObjectMapper;
import com.assignment.senior001.answertjiane.repository.OfficeRepository;
import com.assignment.senior001.answertjiane.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    OrganizationRepository organizationRepository;
    ObjectMapper objectMapper;
    OfficeRepository officeRepository;

    public OrganizationService(OrganizationRepository organizationRepository, ObjectMapper objectMapper, OfficeRepository officeRepository) {
        this.organizationRepository = organizationRepository;
        this.objectMapper = objectMapper;
        this.officeRepository = officeRepository;
    }

    public void createOrg(Organization organization) {
        OrganizationEntity org = objectMapper.toOrganizationEntity(organization);
        for (OfficeEntity office: org.getOffices()) {
            org.getOffices().remove(office);
            office.setOrganizationEntity(org);
            for (EmissionEntity emission: office.getEmissions()) {
                office.getEmissions().remove(emission);
                if (EmissionSource.isValidEmissionSource(emission.getEmissionSource())) {
                    emission.setOffice(office);
                    office.getEmissions().add(emission);
                }
            }
            org.getOffices().add(office);
        }

        org.setOrganizationName(organization.getOrganizationName());
        organizationRepository.save(org);
    }

    public Organization getOrganizationByName(String orgName) {
        return objectMapper.toOrgDTO(organizationRepository.findByOrganizationName(orgName).orElse(null));
    }

    public void createOfficeAndEmissions(Office officeDTO, String orgName) {
        officeDTO.getEmissions().removeIf(emission -> !EmissionSource.isValidEmissionSource(emission.getEmissionSource()));
        OrganizationEntity organization = organizationRepository.findByOrganizationName(orgName).orElse(null);
        if (organization != null) {
            OfficeEntity office = objectMapper.toOfficeEntity(officeDTO);
            for (EmissionEntity emission: office.getEmissions()) {
                office.getEmissions().remove(emission);
                if (EmissionSource.isValidEmissionSource(emission.getEmissionSource())) {
                    emission.setOffice(office);
                    office.getEmissions().add(emission);
                }
            }
            organization.getOffices().add(office);
            organizationRepository.save(organization);
        }
    }
}
