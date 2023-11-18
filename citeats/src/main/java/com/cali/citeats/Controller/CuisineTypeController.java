package com.cali.citeats.Controller;

import com.cali.citeats.Entity.CuisineTypeEntity;
import com.cali.citeats.Service.CuisineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuisinetypes")
public class CuisineTypeController {

    @Autowired
    private CuisineTypeService cuisineTypeService;

    // C - Create a cuisine type
    @PostMapping("/createCuisineType")
    public ResponseEntity<CuisineTypeEntity> createCuisineType(@RequestBody CuisineTypeEntity cuisineType) {
        CuisineTypeEntity createdCuisineType = cuisineTypeService.createCuisineType(cuisineType);
        return new ResponseEntity<>(createdCuisineType, HttpStatus.CREATED);
    }

    // R - Read all cuisine types
    @GetMapping("/getAllCuisineTypes")
    public ResponseEntity<List<CuisineTypeEntity>> getAllCuisineTypes() {
        List<CuisineTypeEntity> cuisineTypes = cuisineTypeService.getAllCuisineTypes();
        return new ResponseEntity<>(cuisineTypes, HttpStatus.OK);
    }

    // U - Update a cuisine type
    @PutMapping("/updateCuisineType/{id}")
    public ResponseEntity<CuisineTypeEntity> updateCuisineType(@PathVariable int id, @RequestBody CuisineTypeEntity cuisineType) {
        CuisineTypeEntity updatedCuisineType = cuisineTypeService.updateCuisineType(id, cuisineType);
        if (updatedCuisineType != null) {
            return new ResponseEntity<>(updatedCuisineType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // D - Delete a cuisine type
    @DeleteMapping("/deleteCuisineType/{id}")
    public ResponseEntity<Void> deleteCuisineType(@PathVariable int id) {
        if (cuisineTypeService.deleteCuisineType(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
