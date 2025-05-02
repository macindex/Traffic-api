package com.project.traffic.domain.service;

import com.project.traffic.domain.model.StatusVehicle;
import com.project.traffic.domain.model.Vehicle;
import com.project.traffic.domain.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegisterVehicleService {

    private final VehicleRepository vehicleRepository;

//    @Autowired
//    public RegisterVehicleService(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }

    @Transactional
    public Vehicle register(Vehicle newVehicle){
        newVehicle.setStatus(StatusVehicle.REGULAR);
        newVehicle.setDateRegister(LocalDateTime.now());

        return vehicleRepository.save(newVehicle);
    }
}
