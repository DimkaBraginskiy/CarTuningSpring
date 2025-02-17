package com.api.carTuning.serviceImpl;

import com.api.carTuning.dto.VehicleCreateDTO;
import com.api.carTuning.dto.VehicleResponseDTO;
import com.api.carTuning.mapper.VehicleMapper;
import com.api.carTuning.model.Tuning;
import com.api.carTuning.model.Vehicle;
import com.api.carTuning.repository.VehicleRepository;
import com.api.carTuning.service.VehicleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    VehicleRepository vehicleRepository;
    @Override
    public VehicleResponseDTO createVehicle(VehicleCreateDTO vehicleCreateDto) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleCreateDto);
        vehicleRepository.save(vehicle);
        return VehicleMapper.toDto(vehicle);
    }

    @Override
    public VehicleResponseDTO getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        return VehicleMapper.toDto(vehicle);
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream().map(VehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional // if error occurs - rolls back
    public void deleteVehicle(Long id) {
        if(!vehicleRepository.existsById(id)){
            throw new RuntimeException("Vehicle not found");
        }
        vehicleRepository.deleteById(id);
    }
}
