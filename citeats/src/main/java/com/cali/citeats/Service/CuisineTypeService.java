package com.cali.citeats.Service;

import com.cali.citeats.Entity.CuisineTypeEntity;
import com.cali.citeats.Repository.CuisineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuisineTypeService {

    private final CuisineTypeRepository cuisineTypeRepository;

    @Autowired
    public CuisineTypeService(CuisineTypeRepository cuisineTypeRepository) {
        this.cuisineTypeRepository = cuisineTypeRepository;
    }

    public List<CuisineTypeEntity> getAllCuisineTypes() {
        return cuisineTypeRepository.findAll();
    }

    public CuisineTypeEntity getCuisineTypeById(int id) {
        Optional<CuisineTypeEntity> cuisineType = cuisineTypeRepository.findById(id);
        return cuisineType.orElse(null);
    }

    public CuisineTypeEntity createCuisineType(CuisineTypeEntity cuisineType) {
        return cuisineTypeRepository.save(cuisineType);
    }

    public CuisineTypeEntity updateCuisineType(int id, CuisineTypeEntity cuisineType) {
        Optional<CuisineTypeEntity> existingCuisineType = cuisineTypeRepository.findById(id);

        if (existingCuisineType.isPresent()) {
            cuisineType.setCuisineTypeId(id);
            return cuisineTypeRepository.save(cuisineType);
        } else {
            return null;
        }
    }

    public boolean deleteCuisineType(int id) {
        if (cuisineTypeRepository.existsById(id)) {
            cuisineTypeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
