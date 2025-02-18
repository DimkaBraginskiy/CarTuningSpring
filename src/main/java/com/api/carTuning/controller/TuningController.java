package com.api.carTuning.controller;

import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.dto.TuningCreateDTO;
import com.api.carTuning.dto.TuningResponseDTO;
import com.api.carTuning.exception.TuningNotFoundException;
import com.api.carTuning.service.TuningService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tunings")
public class TuningController {
    private final TuningService tuningService;

    public TuningController(TuningService tuningService) {
        this.tuningService = tuningService;
    }
    @PostMapping
    public ResponseEntity<TuningResponseDTO> createTuning(@RequestBody @Valid TuningCreateDTO tuningCreateDTO){
        TuningResponseDTO responseDTO = tuningService.createTuning(tuningCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TuningResponseDTO> getTuning(@PathVariable Long id){
        TuningResponseDTO responseDTO = tuningService.getTuningById(id);
        return ResponseEntity.ok(responseDTO);
    }
    @GetMapping
    public ResponseEntity<List<TuningResponseDTO>> getAllTunings(){
        List<TuningResponseDTO> responseTunings = tuningService.getAllTunings();
        return ResponseEntity.ok(responseTunings);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteTuning(@PathVariable Long id){
        tuningService.deleteTuning(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Tuning with ID " + id + " has been successfully removed.");
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleTuningNotFound(TuningNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
