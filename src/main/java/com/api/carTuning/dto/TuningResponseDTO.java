package com.api.carTuning.dto;

import net.bytebuddy.asm.Advice;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TuningResponseDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
}
