package com.project.traffic.api.model;

import com.project.traffic.domain.model.StatusVehicle;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VehicleModel {

    private Long id;
    private String nameOwner;
    private String brand;
    private String model;
    private String plate;
    private StatusVehicle status;
    private OffsetDateTime dateRegister;
    private OffsetDateTime dateSeizure;
}
