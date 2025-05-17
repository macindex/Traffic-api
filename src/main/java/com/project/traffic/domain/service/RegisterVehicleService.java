package com.project.traffic.domain.service;

import com.project.traffic.domain.exception.BusinessException;
import com.project.traffic.domain.model.Owner;
import com.project.traffic.domain.model.StatusVehicle;
import com.project.traffic.domain.model.Vehicle;
import com.project.traffic.domain.repository.OwnerRepository;
import com.project.traffic.domain.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RegisterVehicleService {

    private final VehicleRepository vehicleRepository;
    private final RegisterOwnerService registerOwnerService;

//    @Autowired
//    public RegisterVehicleService(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }

    @Transactional
    public Vehicle register(Vehicle newVehicle){

        if (newVehicle.getId() != null){
            throw new BusinessException("vehicle to be registered must not have a code.");
        }


        boolean plateInUse = vehicleRepository.findByPlate(newVehicle.getPlate())
                .filter(vehicle -> !vehicle.equals(newVehicle)).isPresent();
        if (plateInUse){
            throw new BusinessException("There is already a vehicle with this plate");
        }
//        Owner owner = ownerRepository.findById(newVehicle.getOwner().getId()).orElseThrow(() -> new BusinessException("Owner not found!"));
        Owner owner = registerOwnerService.search(newVehicle.getOwner().getId());

        newVehicle.setOwner(owner);
        newVehicle.setStatus(StatusVehicle.REGULAR);
        newVehicle.setDateRegister(OffsetDateTime.now());

        return vehicleRepository.save(newVehicle);
    }
}
