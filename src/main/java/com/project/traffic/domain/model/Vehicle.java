package com.project.traffic.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
    @ManyToOne
//    @JoinColumn(name = "owner_id")
    private Owner owner;
    private String brand;
    private String model;
    private String plate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusVehicle status;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateRegister;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateSeizure;
}
