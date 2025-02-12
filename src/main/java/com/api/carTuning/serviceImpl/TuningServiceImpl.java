package com.api.carTuning.serviceImpl;

import com.api.carTuning.dto.TuningCreateDTO;
import com.api.carTuning.dto.TuningResponseDTO;
import com.api.carTuning.service.TuningService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuningServiceImpl implements TuningService {
    @Override
    public TuningResponseDTO createTuning(TuningCreateDTO tuningCreateDto) {
        return null;
    }

    @Override
    public TuningResponseDTO getTuningById(Long id) {
        return null;
    }

    @Override
    public List<TuningResponseDTO> getAllTunings() {
        return null;
    }

    @Override
    public void deleteTuning(Long id) {

    }
}
