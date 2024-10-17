package org.example.thuc_hanh_module_4.repository;

import org.example.thuc_hanh_module_4.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Long> {
    @Query("SELECT k FROM KhuyenMai k WHERE k.startTime >= :startTime AND k.endTime <= :endTime")
    List<KhuyenMai> findByStartTimeAndEndTime(@Param("startTime") LocalDate startTime, @Param("endTime") LocalDate endTime);

    @Query("SELECT k FROM KhuyenMai k WHERE k.startTime >= :startTime AND k.endTime <= :endTime AND k.rate = :rate")
    List<KhuyenMai> findByStartTimeAndEndTimeAndRate(@Param("startTime") LocalDate startTime, @Param("endTime") LocalDate endTime, @Param("rate") double rate);

    List<KhuyenMai> findByEndTime(LocalDate endTime);

    List<KhuyenMai> findByEndTimeAndRate(LocalDate endTime, double rate);
}
