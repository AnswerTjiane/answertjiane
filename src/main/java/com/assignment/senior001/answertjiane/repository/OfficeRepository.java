package com.assignment.senior001.answertjiane.repository;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dao.OfficeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository extends CrudRepository<OfficeEntity, String> {

    Optional<OfficeEntity> findByOfficeName(String officeName);
}
