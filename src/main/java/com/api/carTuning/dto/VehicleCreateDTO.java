package com.api.carTuning.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class VehicleCreateDTO {
    @NotNull(message = "Production Year can not be null")
    private int productionYear;
    @NotNull(message = "Brand can not be null")
    private String brand;
}
