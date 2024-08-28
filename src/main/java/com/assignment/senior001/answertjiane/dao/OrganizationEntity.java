package com.assignment.senior001.answertjiane.dao;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organization")
public class OrganizationEntity {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(unique = true)
    private String organizationName;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "organizationEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OfficeEntity> officeEntities = new ArrayList<>();

    public void setOffices(List<OfficeEntity> officeEntities) {
        this.officeEntities = officeEntities;
    }

    public List<OfficeEntity> getOffices() {
        return officeEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OfficeEntity> getOfficeEntities() {
        return officeEntities;
    }

    public void setOfficeEntities(List<OfficeEntity> officeEntities) {
        this.officeEntities = officeEntities;
    }
}
