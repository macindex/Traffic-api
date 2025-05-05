package com.project.traffic.api.controller;

import com.project.traffic.domain.exception.BusinessException;
import com.project.traffic.domain.model.Vehicle;
import com.project.traffic.domain.repository.VehicleRepository;
import com.project.traffic.domain.service.RegisterVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;
    private final RegisterVehicleService registerVehicleService;

    @GetMapping
    public List<Vehicle> list(){
        return vehicleRepository.findAll();
    }
    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> search(@PathVariable Long vehicleId){
        return vehicleRepository.findById(vehicleId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle register(@RequestBody Vehicle vehicle){
        return registerVehicleService.register(vehicle);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> capt(BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
