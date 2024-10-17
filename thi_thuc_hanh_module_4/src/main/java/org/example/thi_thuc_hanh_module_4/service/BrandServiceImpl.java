package org.example.thi_thuc_hanh_module_4.service;

import org.example.thi_thuc_hanh_module_4.model.Brand;
import org.example.thi_thuc_hanh_module_4.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
