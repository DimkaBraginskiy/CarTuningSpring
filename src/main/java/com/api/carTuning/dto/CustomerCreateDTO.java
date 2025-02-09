package com.api.carTuning.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CustomerCreateDTO {
    @NotNull(message = "First name can not be null")
    @Size(max = 50)
    private String firstName;
    @NotNull(message = "Last name can not be null")
    @Size(max = 50)
    private String lastName;
    @NotNull(message = "Email can not be null")
    @Email(message = "Not an email format")
    @Size(max = 50)
    private String email;

}
