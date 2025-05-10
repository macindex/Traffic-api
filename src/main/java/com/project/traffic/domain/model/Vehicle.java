package com.project.traffic.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Vehicle {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.OwnerId.class)
    @ManyToOne
//    @JoinColumn(name = "owner_id")
    @NotNull
    private Owner owner;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9]{4}[0-9A-Z][0-9]{2}")
    private String plate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusVehicle status;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateRegister;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateSeizure;
}
