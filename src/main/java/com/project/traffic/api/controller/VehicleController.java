package com.project.traffic.api.controller;

import com.project.traffic.api.model.VehicleModel;
import com.project.traffic.domain.exception.BusinessException;
import com.project.traffic.domain.model.Vehicle;
import com.project.traffic.domain.repository.VehicleRepository;
import com.project.traffic.domain.service.RegisterVehicleService;
import jakarta.validation.Valid;
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
    public ResponseEntity<VehicleModel> search(@PathVariable Long vehicleId){
        return vehicleRepository.findById(vehicleId)
                .map(vehicle -> {
                    var vehicleModel = new VehicleModel();
                    vehicleModel.setId(vehicle.getId());
                    vehicleModel.setNameOwner(vehicle.getOwner().getName());
                    vehicleModel.setBrand(vehicle.getBrand());
                    vehicleModel.setModel(vehicle.getModel());
                    vehicleModel.setPlate(vehicle.getPlate());
                    vehicleModel.setStatus(vehicle.getStatus());
                    vehicleModel.setDateRegister(vehicle.getDateRegister());
                    vehicleModel.setDateSeizure(vehicle.getDateSeizure());
                    return vehicleModel;
                })
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle register(@Valid @RequestBody Vehicle vehicle){
        return registerVehicleService.register(vehicle);
    }
}
