package com.api.carTuning.dto;

import lombok.*;
import net.bytebuddy.asm.Advice;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TuningResponseDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
}
