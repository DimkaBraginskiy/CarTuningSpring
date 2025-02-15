package com.api.carTuning.mapper;

import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.dto.TuningCreateDTO;
import com.api.carTuning.dto.TuningResponseDTO;
import com.api.carTuning.model.Customer;
import com.api.carTuning.model.Tuning;

public class TuningMapper {
    public static Tuning toEntity(TuningCreateDTO dto){

        return Tuning.builder()
                .name(dto.getName())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .price(dto.getPrice()).build();
    }


    public static TuningResponseDTO toDto(Tuning tuning){
        return new TuningResponseDTO(
                tuning.getId(),
                tuning.getName(),
                tuning.getStartDate(),
                tuning.getEndDate(),
                tuning.getPrice()
        );
    }
}
