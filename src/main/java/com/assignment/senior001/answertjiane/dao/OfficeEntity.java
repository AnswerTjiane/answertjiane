package com.assignment.senior001.answertjiane.dao;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "office")
public class OfficeEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organizationEntity;

    @OneToMany(mappedBy = "officeEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmissionEntity> emissions = new ArrayList<>();

    @Column(unique = true)
    private String officeName;

    public OrganizationEntity getOrganizationEntity() {
        return organizationEntity;
    }

    public void setOrganizationEntity(OrganizationEntity organizationEntity) {
        this.organizationEntity = organizationEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public List<EmissionEntity> getEmissions() {
        return emissions;
    }

    public void setEmissions(List<EmissionEntity> emissions) {
        this.emissions = emissions;
    }
}