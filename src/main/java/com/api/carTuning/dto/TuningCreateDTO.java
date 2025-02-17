package com.api.carTuning.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TuningCreateDTO {
    @NotNull
    @Size(max = 50)
    private String name;
    @NotNull(message = "Start Date can not be null")
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
}
