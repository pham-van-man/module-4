package org.example.thuc_hanh_module_4.service;

import org.example.thuc_hanh_module_4.model.KhuyenMai;
import org.example.thuc_hanh_module_4.repository.KhuyenMaiRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    private final KhuyenMaiRepository khuyenMaiRepository;

    public KhuyenMaiServiceImpl(KhuyenMaiRepository khuyenMaiRepository) {
        this.khuyenMaiRepository = khuyenMaiRepository;
    }

    @Override
    public List<KhuyenMai> getAllKhuyenMai() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public KhuyenMai getKhuyenMai(Long id) {
        return khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteKhuyenMai(Long id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public void saveKhuyenMai(KhuyenMai km) {
        khuyenMaiRepository.save(km);
    }

    @Override
    public List<KhuyenMai> searchKhuyenMai(LocalDate startTime, LocalDate endTime, double rate) {
        if (startTime != null && endTime == null) {
            if (rate == 0) {
                return khuyenMaiRepository.findByEndTime(endTime);

            } else {
                return khuyenMaiRepository.findByEndTimeAndRate(startTime, rate);
            }
        }
        if (startTime == null) {
            startTime = LocalDate.parse("2000-01-01");
        }
        if (endTime == null) {
            endTime = LocalDate.parse("2300-01-01");
        }
        if (rate == 0) {
            return khuyenMaiRepository.findByStartTimeAndEndTime(startTime, endTime);
        } else {
            return khuyenMaiRepository.findByStartTimeAndEndTimeAndRate(startTime, endTime, rate);
        }
    }
}
