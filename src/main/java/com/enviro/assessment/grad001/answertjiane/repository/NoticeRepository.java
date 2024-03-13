package com.enviro.assessment.grad001.answertjiane.repository;

import com.enviro.assessment.grad001.answertjiane.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query(value = "SELECT * FROM notice WHERE investor_id = :investorId AND product_type = :product AND updated_at BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Notice> findByDateRange(@Param("investorId")Long id,  @Param("product") String product, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
