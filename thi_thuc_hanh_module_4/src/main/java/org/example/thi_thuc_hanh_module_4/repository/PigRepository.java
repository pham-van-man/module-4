package org.example.thi_thuc_hanh_module_4.repository;

import org.example.thi_thuc_hanh_module_4.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PigRepository extends JpaRepository<Pig, Long> {
    @Query("SELECT p FROM Pig p WHERE p.code LIKE :code AND p.brand.name LIKE :brandName AND p.timeOut IS NULL")
    Page<Pig> findPigsByCodeAndBrand(Pageable pageable, @Param("code") String code, @Param("brandName") String brandName);

    @Query("SELECT p FROM Pig p WHERE p.code LIKE :code AND p.brand.name LIKE :brandName AND p.timeOut IS NOT NULL")
    Page<Pig> findPigsByCodeAndBrandAndNotNULL(Pageable pageable, @Param("code") String code, @Param("brandName") String brandName);

    @Query("SELECT p FROM Pig p ORDER BY p.weightOut DESC")
    Page<Pig> findTopByWeightOut(Pageable pageable);
}
