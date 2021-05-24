package com.github.hamiltongravito.citiesapi.distances;

import com.github.hamiltongravito.citiesapi.distances.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    @Autowired
    private DistanceService service;

    @GetMapping("/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2) {
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
    }
}