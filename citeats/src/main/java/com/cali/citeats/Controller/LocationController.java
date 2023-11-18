package com.cali.citeats.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cali.citeats.Entity.LocationEntity;
import com.cali.citeats.Service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/addLocation")
    public LocationEntity addLocation(@RequestBody LocationEntity location) {
        return locationService.addLocation(location);
    }

    @GetMapping("/getAllLocations")
    public List<LocationEntity> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/getLocationById/{locationId}")
    public LocationEntity getLocationById(@PathVariable int locationId) {
        return locationService.getLocationById(locationId);
    }

    @DeleteMapping("/deleteLocation/{locationId}")
    public String deleteLocation(@PathVariable int locationId) {
        return locationService.deleteLocation(locationId);
    }
}
