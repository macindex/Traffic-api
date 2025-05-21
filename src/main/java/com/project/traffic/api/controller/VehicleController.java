package com.project.traffic.api.controller;

import com.project.traffic.api.assembler.VehicleAssembler;
import com.project.traffic.api.model.VehicleModel;
import com.project.traffic.domain.exception.BusinessException;
import com.project.traffic.domain.model.Vehicle;
import com.project.traffic.domain.repository.VehicleRepository;
import com.project.traffic.domain.service.RegisterVehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
//    private final ModelMapper modelMapper;
    private final VehicleAssembler vehicleAssembler;


    @GetMapping
    public List<VehicleModel> list(){
        return vehicleAssembler.toCollectionModel(vehicleRepository.findAll());
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleModel> search(@PathVariable Long vehicleId){
        return vehicleRepository.findById(vehicleId)
                .map(vehicleAssembler::toModel)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        //        { Tudo isso deixa de existir a partir do ModelMapper
//            var vehicleModel = new VehicleModel();
//            vehicleModel.setId(vehicle.getId());
//            vehicleModel.setNameOwner(vehicle.getOwner().getName());
//            vehicleModel.setBrand(vehicle.getBrand());
//            vehicleModel.setModel(vehicle.getModel());
//            vehicleModel.setPlate(vehicle.getPlate());
//            vehicleModel.setStatus(vehicle.getStatus());
//            vehicleModel.setDateRegister(vehicle.getDateRegister());
//            vehicleModel.setDateSeizure(vehicle.getDateSeizure());
//            return vehicleModel;
//        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleModel register(@Valid @RequestBody Vehicle vehicle){
        return vehicleAssembler.toModel(registerVehicleService.register(vehicle));
    }
}
