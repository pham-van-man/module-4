package org.example.thuc_hanh_module_4.service;

import org.example.thuc_hanh_module_4.model.KhuyenMai;

import java.time.LocalDate;
import java.util.List;

public interface KhuyenMaiService {
    List<KhuyenMai> getAllKhuyenMai();

    KhuyenMai getKhuyenMai(Long id);

    void deleteKhuyenMai(Long id);

    void saveKhuyenMai(KhuyenMai km);

    List<KhuyenMai> searchKhuyenMai(LocalDate startTime, LocalDate endTime, double rate);
}
