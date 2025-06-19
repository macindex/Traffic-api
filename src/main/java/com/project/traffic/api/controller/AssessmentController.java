package com.project.traffic.api.controller;

import com.project.traffic.api.assembler.AssessmentAssembler;
import com.project.traffic.api.model.AssessmentModel;
import com.project.traffic.api.model.input.AssessmentInput;
import com.project.traffic.domain.model.Assessment;
import com.project.traffic.domain.service.RegisterAssessmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vehicles/{vehicleId}/assessments")
@AllArgsConstructor
@RestController
public class AssessmentController {

    private final AssessmentAssembler assessmentAssembler;
    private final RegisterAssessmentService registerAssessmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssessmentModel register(@PathVariable Long vehicleId, @Valid @RequestBody AssessmentInput assessmentInput){
        Assessment newAssessment = assessmentAssembler.toEntity(assessmentInput);
        Assessment assessmentRegistered = registerAssessmentService.register(vehicleId, newAssessment);

        return assessmentAssembler.toModel(assessmentRegistered);
    }

}
