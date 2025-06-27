package com.project.traffic.domain.service;

import com.project.traffic.domain.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class SeizureVehicleService {
    private final RegisterVehicleService registerVehicleService;

    @Transactional
    public void seize(Long vehicleId) {
        Vehicle vehicle = registerVehicleService.search(vehicleId);
        vehicle.seize();
    }
    @Transactional
    public void removeSeizure(Long vehicleId){
        Vehicle vehicle = registerVehicleService.search(vehicleId);
        vehicle.removeSeizure();
    }

}
