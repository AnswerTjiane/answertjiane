package com.assignment.senior001.answertjiane.helper;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dao.OfficeEntity;
import com.assignment.senior001.answertjiane.dao.OrganizationEntity;
import com.assignment.senior001.answertjiane.dto.Emission;
import com.assignment.senior001.answertjiane.dto.Office;
import com.assignment.senior001.answertjiane.dto.Organization;

public interface ObjectMapper {

    Emission toEmissionDTO(EmissionEntity emission);

    EmissionEntity toEmissionEntity(Emission dto);

    Organization toOrgDTO(OrganizationEntity organization);

    OrganizationEntity toOrganizationEntity(Organization organization);

    Office toOfficeDTO(OfficeEntity officeEntity);

    OfficeEntity toOfficeEntity(Office office);
}
