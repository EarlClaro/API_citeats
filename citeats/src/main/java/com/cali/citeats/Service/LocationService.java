package com.cali.citeats.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cali.citeats.Entity.LocationEntity;
import com.cali.citeats.Repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationEntity addLocation(LocationEntity location) {
        return locationRepository.save(location);
    }

    public List<LocationEntity> getAllLocations() {
        // Convert Iterable to List
        List<LocationEntity> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public LocationEntity getLocationById(int locationId) {
        Optional<LocationEntity> optionalLocation = locationRepository.findById(locationId);

        if (optionalLocation.isPresent()) {
            return optionalLocation.get();
        } else {
            throw new RuntimeException("Location not found with id: " + locationId);
        }
    }

    public String deleteLocation(int locationId) {
        Optional<LocationEntity> optionalLocation = locationRepository.findById(locationId);

        if (optionalLocation.isPresent()) {
            LocationEntity existingLocation = optionalLocation.get();
            locationRepository.delete(existingLocation);
            return "Location with id " + locationId + " has been deleted.";
        } else {
            throw new RuntimeException("Location not found with id: " + locationId);
        }
    }
}
