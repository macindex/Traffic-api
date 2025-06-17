package com.project.traffic.domain.service;

import com.project.traffic.domain.model.Assessment;
import com.project.traffic.domain.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegisterAssessmentService {

    private RegisterVehicleService registerVehicleService;

    @Transactional
    public Assessment register(Long vehicleId, Assessment newAssessment){
        Vehicle vehicle = registerVehicleService.search(vehicleId);

        return vehicle.addAssessment(newAssessment);
    }
}
