package com.api.carTuning.controller;

import com.api.carTuning.dto.VehicleCreateDTO;
import com.api.carTuning.dto.VehicleResponseDTO;
import com.api.carTuning.exception.VehicleNotFoundException;
import com.api.carTuning.service.VehicleService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/")
    public ResponseEntity<VehicleResponseDTO> createVehicle(@RequestBody @Valid VehicleCreateDTO vehicleCreateDTO){
        VehicleResponseDTO responseDTO = vehicleService.createVehicle(vehicleCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicle(@PathVariable Long id){
        VehicleResponseDTO responseDTO = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(responseDTO);
    }
    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles(){
        List<VehicleResponseDTO> responseVehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(responseVehicles);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Vehicle with ID " + id + " has been successfully removed.");
        return ResponseEntity.ok(response);
    }
    @ExceptionHandler
    public ResponseEntity<String> handleVehicleNotFound(VehicleNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
