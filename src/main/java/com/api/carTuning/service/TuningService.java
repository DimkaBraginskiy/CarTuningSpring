package com.api.carTuning.service;

import com.api.carTuning.dto.TuningCreateDTO;
import com.api.carTuning.dto.TuningResponseDTO;

import java.util.List;

public interface TuningService {
    TuningResponseDTO createTuning(TuningCreateDTO tuningCreateDto);
    TuningResponseDTO getTuningById(Long id);
    List<TuningResponseDTO> getAllTunings();
    void deleteTuning(Long id);
}
