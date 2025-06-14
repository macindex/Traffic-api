package com.project.traffic.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleInput {

    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    private String plate;

    @NotNull
    @Valid
    private OwnerIdInput owner;
}
