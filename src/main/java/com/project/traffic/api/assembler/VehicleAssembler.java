package com.project.traffic.api.assembler;

import com.project.traffic.api.model.VehicleModel;
import com.project.traffic.domain.model.Vehicle;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VehicleAssembler {

    private final ModelMapper modelMapper;

    public VehicleModel toModel(Vehicle vehicle){
        return modelMapper.map(vehicle, VehicleModel.class);
    }
    public List<VehicleModel> toCollectionModel(List<Vehicle> vehicles){
        return vehicles.stream().map(this::toModel).toList();
    }

}

