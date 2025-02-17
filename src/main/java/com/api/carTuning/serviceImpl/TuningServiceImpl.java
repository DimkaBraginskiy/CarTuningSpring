package com.api.carTuning.serviceImpl;

import com.api.carTuning.dto.TuningCreateDTO;
import com.api.carTuning.dto.TuningResponseDTO;
import com.api.carTuning.mapper.TuningMapper;
import com.api.carTuning.model.Tuning;
import com.api.carTuning.repository.TuningRepository;
import com.api.carTuning.service.TuningService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TuningServiceImpl implements TuningService {
    TuningRepository tuningRepository;
    @Override
    public TuningResponseDTO createTuning(TuningCreateDTO tuningCreateDto) {
        Tuning tuning = TuningMapper.toEntity(tuningCreateDto);
        tuningRepository.save(tuning);
        return TuningMapper.toDto(tuning);
    }

    @Override
    public TuningResponseDTO getTuningById(Long id) {
        Tuning tuning = tuningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tuning not found"));

        return TuningMapper.toDto(tuning);
    }

    @Override
    public List<TuningResponseDTO> getAllTunings() {
        return tuningRepository.findAll()
                .stream().map(TuningMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional // if error occurs - rolls back
    public void deleteTuning(Long id) {
        if(!tuningRepository.existsById(id)){
            throw new RuntimeException("Tuning not found");
        }
        tuningRepository.deleteById(id);
    }
}
