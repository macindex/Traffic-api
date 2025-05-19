package com.project.traffic.common;

import com.project.traffic.api.model.VehicleModel;
import com.project.traffic.domain.model.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Vehicle.class, VehicleModel.class)
                .addMappings(mapper -> mapper.map(Vehicle::getPlate, VehicleModel
                        ::setNumPlate));

        return modelMapper;
    }
}
