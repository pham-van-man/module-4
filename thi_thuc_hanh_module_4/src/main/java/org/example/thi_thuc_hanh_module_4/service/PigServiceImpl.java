package org.example.thi_thuc_hanh_module_4.service;

import org.example.thi_thuc_hanh_module_4.model.Pig;
import org.example.thi_thuc_hanh_module_4.repository.PigRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PigServiceImpl implements PigService {
    private final PigRepository pigRepository;

    public PigServiceImpl(PigRepository pigRepository) {
        this.pigRepository = pigRepository;
    }

    @Override
    public Page<Pig> getPigs(Pageable pageable, String q, String status, String brandName) {
        if (q == null || q.isEmpty()) {
            q = "";
        }
        if (status == null || status.isEmpty()) {
            brandName = "";
        }
        q = "%" + q + "%";
        brandName = "%" + brandName + "%";
        if (Objects.equals(status, "isSell")) {
            return pigRepository.findPigsByCodeAndBrand(pageable, q, brandName);
        } else if (Objects.equals(status, "notSell")) {
            return pigRepository.findPigsByCodeAndBrandAndNotNULL(pageable, q, brandName);
        } else {
            return pigRepository.findAll(pageable);
        }
    }

    @Override
    public Pig getPig(Long id) {
        return pigRepository.findById(id).orElse(null);
    }

    @Override
    public void SavePig(Pig pig) {
        pigRepository.save(pig);
    }

    @Override
    public void deletePig(Pig pig) {
        pigRepository.delete(pig);
    }

    @Override
    public Page<Pig> getPigsByWeightOut(Pageable pageable) {
        return pigRepository.findTopByWeightOut(pageable);
    }
}
