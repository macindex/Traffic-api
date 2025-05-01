package com.project.traffic.api.controller;

import com.project.traffic.domain.model.Vehicle;
import com.project.traffic.domain.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> list(){
        return vehicleRepository.findAll();
    }
    @GetMapping("/vehicleId")
    public ResponseEntity<Vehicle> search(@PathVariable Long vehicleId){
        return vehicleRepository.findById(vehicleId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
