package com.assignment.senior001.answertjiane.repository;

import com.assignment.senior001.answertjiane.dao.OrganizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<OrganizationEntity, String> {

    Optional<OrganizationEntity> findByOrganizationName(String name);
}
