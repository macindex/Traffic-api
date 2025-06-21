package com.project.traffic.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.traffic.domain.exception.BusinessException;
import com.project.traffic.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Vehicle {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Owner owner;
    private String brand;
    private String model;
    private String plate;

    @Enumerated(EnumType.STRING)
    private StatusVehicle status;
    private OffsetDateTime dateRegister;
    private OffsetDateTime dateSeizure;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Assessment> assessments = new ArrayList<>();

    public Assessment addAssessment(Assessment assessment){
        assessment.setDateOccurrence(OffsetDateTime.now());
        assessment.setVehicle(this);
        getAssessments().add(assessment);
        return assessment;
    }
    public void seize(){
        if (itsBeenSeized()){
            throw new BusinessException("The vehicle is already impounded");
        }
        setStatus(StatusVehicle.SEIZED);
        setDataSeizure(OffsetDateTime.now());
        //if (StatusVehicle.SEIZED.equals(getStatus())){
        //} FICARIA DESTA FORMA
    }

    public boolean itsBeenSeized() {
        return StatusVehicle.SEIZED.equals(getStatus());
    }
}
