package com.cali.citeats.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cali.citeats.Entity.LocationEntity;
import com.cali.citeats.Repository.LocationRepository;

@Service
@CrossOrigin(origins = "http://localhost:3000") 
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationEntity addLocation(LocationEntity location) {
        return locationRepository.save(location);
    }

    public List<LocationEntity> getAllLocations() {
        return (List<LocationEntity>) locationRepository.findAll();
    }

    public LocationEntity getLocationById(int locationId) {
        Optional<LocationEntity> optionalLocation = locationRepository.findById(locationId);
        return optionalLocation.orElse(null);
    }

    public LocationEntity updateLocation(int locationId, LocationEntity updatedLocation) {
        LocationEntity existingLocation = locationRepository.findById(locationId).orElse(null);
        if (existingLocation != null) {
            existingLocation.setRestaurantId(updatedLocation.getRestaurantId());
            existingLocation.setLatitude(updatedLocation.getLatitude());
            existingLocation.setLongitude(updatedLocation.getLongitude());
            existingLocation.setGoogleMapLink(updatedLocation.getGoogleMapLink()); // Add this line to set the GoogleMapLink
            // Add other fields to update as needed
            return locationRepository.save(existingLocation);
        }
        return null;
    }

    public String deleteLocation(int locationId) {
        Optional<LocationEntity> optionalLocation = locationRepository.findById(locationId);
        if (optionalLocation.isPresent()) {
            locationRepository.deleteById(locationId);
            return "Location with ID " + locationId + " deleted successfully";
        } else {
            return "Location with ID " + locationId + " not found";
        }
    }
}
