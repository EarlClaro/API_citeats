package com.cali.citeats.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cali.citeats.Entity.LocationEntity;
import com.cali.citeats.Service.LocationService;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/addLocation")
    public ResponseEntity<LocationEntity> addLocation(@RequestBody LocationEntity location) {
        LocationEntity addedLocation = locationService.addLocation(location);
        return new ResponseEntity<>(addedLocation, HttpStatus.CREATED);
    }

    @GetMapping("/getAllLocations")
    public ResponseEntity<List<LocationEntity>> getAllLocations() {
        List<LocationEntity> locations = locationService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/getLocationById/{locationId}")
    public ResponseEntity<LocationEntity> getLocationById(@PathVariable int locationId) {
        LocationEntity location = locationService.getLocationById(locationId);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateLocation/{locationId}")
    public ResponseEntity<LocationEntity> updateLocation(@PathVariable int locationId, @RequestBody LocationEntity updatedLocation) {
        LocationEntity location = locationService.updateLocation(locationId, updatedLocation);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteLocation/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable int locationId) {
        String result = locationService.deleteLocation(locationId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
