package com.api.carTuning.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class TuningCreateDTO {
    @NotNull
    @Size(max = 50)
    private String name;
    @NotNull(message = "Start Date can not be null")
    private LocalDate startDate;

    private LocalDate endDate;
    private BigDecimal price;
}
