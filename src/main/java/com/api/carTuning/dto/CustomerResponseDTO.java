package com.api.carTuning.dto;

import com.api.carTuning.model.Vehicle;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
}
