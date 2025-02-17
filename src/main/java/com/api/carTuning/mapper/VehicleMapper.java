package com.api.carTuning.mapper;

import com.api.carTuning.dto.VehicleCreateDTO;
import com.api.carTuning.dto.VehicleResponseDTO;
import com.api.carTuning.model.Vehicle;

public class VehicleMapper {
    public static Vehicle toEntity(VehicleCreateDTO dto){
        return Vehicle.builder()
                .brand(dto.getBrand())
                .horsePower(dto.getHorsePower())
                .productionYear(dto.getProductionYear())
                .build();
    }

    public static VehicleResponseDTO toDto(Vehicle vehicle){
        return new VehicleResponseDTO(
                vehicle.getId(),
                vehicle.getProductionYear(),
                vehicle.getHorsePower(),
                vehicle.getBrand()
        );
    }
}
