package com.enviro.assessment.grad001.answertjiane.repository;

import com.enviro.assessment.grad001.answertjiane.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
            value = "SELECT * FROM PRODUCT p WHERE p.id = :id AND p.product_type = :productType",
            nativeQuery = true)
    Optional<Product> findByIdAndProductType(@Param("id") Long id,@Param("productType") String productType);
}
