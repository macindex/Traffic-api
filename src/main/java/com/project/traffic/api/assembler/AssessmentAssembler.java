package com.project.traffic.api.assembler;

import com.project.traffic.api.model.AssessmentModel;
import com.project.traffic.api.model.input.AssessmentInput;
import com.project.traffic.domain.model.Assessment;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AssessmentAssembler {

    private final ModelMapper modelMapper;

    public Assessment toEntity(AssessmentInput assessmentInput){
        return modelMapper.map(assessmentInput, Assessment.class);
    }

    public AssessmentModel toModel(Assessment assessment){
        return modelMapper.map(assessment, AssessmentModel.class);
    }

    public List<AssessmentModel> toCollectionModel(List<Assessment> assessments){
        return assessments.stream().map(this::toModel).toList();
    }
}
