package com.enviro.assessment.grad001.answertjiane.repository;

import com.enviro.assessment.grad001.answertjiane.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {

    Optional<Investor> findByName(String name);
}
