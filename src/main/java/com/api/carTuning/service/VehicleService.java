package com.api.carTuning.service;

import com.api.carTuning.dto.VehicleCreateDTO;
import com.api.carTuning.dto.VehicleResponseDTO;

import java.util.List;

public interface VehicleService {
    VehicleResponseDTO createVehicle(VehicleCreateDTO vehicleCreateDto);
    VehicleResponseDTO getVehicleById(Long id);
    List<VehicleResponseDTO> getAllVehicles();
    void deleteVehicle(Long id);
}
