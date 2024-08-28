package com.assignment.senior001.answertjiane.helper;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dao.OfficeEntity;
import com.assignment.senior001.answertjiane.dao.OrganizationEntity;
import com.assignment.senior001.answertjiane.dto.Emission;
import com.assignment.senior001.answertjiane.dto.Office;
import com.assignment.senior001.answertjiane.dto.Organization;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperImpl implements ObjectMapper {

    @Override
    public Emission toEmissionDTO(EmissionEntity emission) {
        if ( emission == null ) {
            return null;
        }

        Emission emission1 = new Emission();

        emission1.setAmount( emission.getAmount() );
        emission1.setEmissionSource( emission.getEmissionSource() );
        emission1.setComments( emission.getComments() );
        emission1.setMonthRecorded( emission.getMonthRecorded() );

        return emission1;
    }

    @Override
    public EmissionEntity toEmissionEntity(Emission dto) {
        if ( dto == null ) {
            return null;
        }

        EmissionEntity emissionEntity = new EmissionEntity();

        emissionEntity.setAmount( dto.getAmount() );
        emissionEntity.setEmissionSource( dto.getEmissionSource() );
        emissionEntity.setComments( dto.getComments() );
        emissionEntity.setMonthRecorded( dto.getMonthRecorded() );

        return emissionEntity;
    }

    @Override
    public Organization toOrgDTO(OrganizationEntity organization) {
        if ( organization == null ) {
            return null;
        }

        Organization organization1 = new Organization();

        organization1.setOrganizationName( organization.getOrganizationName() );
        organization1.setOffices( officeEntityListToOfficeList( organization.getOffices() ) );

        return organization1;
    }

    @Override
    public OrganizationEntity toOrganizationEntity(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationEntity organizationEntity = new OrganizationEntity();

        organizationEntity.setOffices( officeListToOfficeEntityList( organization.getOffices() ) );
        organizationEntity.setOrganizationName( organization.getOrganizationName() );

        return organizationEntity;
    }

    @Override
    public Office toOfficeDTO(OfficeEntity officeEntity) {
        if ( officeEntity == null ) {
            return null;
        }

        Office office = new Office();

        office.setOfficeName( officeEntity.getOfficeName() );
        office.setEmissions( emissionEntityListToEmissionList( officeEntity.getEmissions() ) );

        return office;
    }

    @Override
    public OfficeEntity toOfficeEntity(Office office) {
        if ( office == null ) {
            return null;
        }

        OfficeEntity officeEntity = new OfficeEntity();

        officeEntity.setOfficeName( office.getOfficeName() );
        officeEntity.setEmissions( emissionListToEmissionEntityList( office.getEmissions() ) );

        return officeEntity;
    }

    protected List<Office> officeEntityListToOfficeList(List<OfficeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Office> list1 = new ArrayList<Office>( list.size() );
        for ( OfficeEntity officeEntity : list ) {
            list1.add( toOfficeDTO( officeEntity ) );
        }

        return list1;
    }

    protected List<OfficeEntity> officeListToOfficeEntityList(List<Office> list) {
        if ( list == null ) {
            return null;
        }

        List<OfficeEntity> list1 = new ArrayList<OfficeEntity>( list.size() );
        for ( Office office : list ) {
            list1.add( toOfficeEntity( office ) );
        }

        return list1;
    }

    protected List<Emission> emissionEntityListToEmissionList(List<EmissionEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Emission> list1 = new ArrayList<Emission>( list.size() );
        for ( EmissionEntity emissionEntity : list ) {
            list1.add( toEmissionDTO( emissionEntity ) );
        }

        return list1;
    }

    protected List<EmissionEntity> emissionListToEmissionEntityList(List<Emission> list) {
        if ( list == null ) {
            return null;
        }

        List<EmissionEntity> list1 = new ArrayList<EmissionEntity>( list.size() );
        for ( Emission emission : list ) {
            list1.add( toEmissionEntity( emission ) );
        }

        return list1;
    }
}
