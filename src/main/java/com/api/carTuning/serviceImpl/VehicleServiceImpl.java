package com.api.carTuning.serviceImpl;

import com.api.carTuning.dto.VehicleCreateDTO;
import com.api.carTuning.dto.VehicleResponseDTO;
import com.api.carTuning.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public VehicleResponseDTO createVehicle(VehicleCreateDTO vehicleCreateDto) {
        return null;
    }

    @Override
    public VehicleResponseDTO getVehicleById(Long id) {
        return null;
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return null;
    }

    @Override
    public void deleteVehicle(Long id) {

    }
}
