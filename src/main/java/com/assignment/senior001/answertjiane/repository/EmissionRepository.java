package com.assignment.senior001.answertjiane.repository;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dao.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmissionRepository extends JpaRepository<EmissionEntity, String> {
    List<EmissionEntity> findByOfficeEntity(OfficeEntity officeEntity);
    List<EmissionEntity> findByEmissionSource(String emissionSource);
}
