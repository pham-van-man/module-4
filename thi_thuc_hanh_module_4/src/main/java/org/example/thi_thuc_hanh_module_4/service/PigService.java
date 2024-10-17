package org.example.thi_thuc_hanh_module_4.service;

import org.example.thi_thuc_hanh_module_4.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PigService {
    Page<Pig> getPigs(Pageable pageable, String q, String status, String brandName);

    Pig getPig(Long id);

    void SavePig(Pig pig);

    void deletePig(Pig pig);

    Page<Pig> getPigsByWeightOut(Pageable pageable);
}
