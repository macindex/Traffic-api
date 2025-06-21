package com.project.traffic.api.controller;

import com.project.traffic.api.assembler.AssessmentAssembler;
import com.project.traffic.api.model.AssessmentModel;
import com.project.traffic.api.model.input.AssessmentInput;
import com.project.traffic.domain.model.Assessment;
import com.project.traffic.domain.model.Vehicle;
import com.project.traffic.domain.service.RegisterAssessmentService;
import com.project.traffic.domain.service.RegisterVehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vehicles/{vehicleId}/assessments")
@AllArgsConstructor
@RestController
public class AssessmentController {

    private final AssessmentAssembler assessmentAssembler;
    private final RegisterAssessmentService registerAssessmentService;
    private final RegisterVehicleService registerVehicleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssessmentModel register(@PathVariable Long vehicleId, @Valid @RequestBody AssessmentInput assessmentInput){
        Assessment newAssessment = assessmentAssembler.toEntity(assessmentInput);
        Assessment assessmentRegistered = registerAssessmentService.register(vehicleId, newAssessment);

        return assessmentAssembler.toModel(assessmentRegistered);
    }
    @GetMapping
    public List<AssessmentModel> list(@PathVariable Long vehicleId){
        Vehicle vehicle = registerVehicleService.search(vehicleId);
        return assessmentAssembler.toCollectionModel(vehicle.getAssessments());
    }

}
