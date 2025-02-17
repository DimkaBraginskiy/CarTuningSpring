package com.api.carTuning.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDTO {
    private Long id;
    private int productionYear;
    private int horsePower;
    private String brand;
}
