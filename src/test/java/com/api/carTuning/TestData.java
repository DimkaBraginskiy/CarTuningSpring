package com.api.carTuning;

import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.model.Customer;

import java.time.LocalDate;


public class TestData{
    public static Customer getTestCustomer(){
        return  Customer.builder()
                .id(20L)
                .firstName("Podopitniy")
                .lastName("Chel")
                .birthDate(LocalDate.of(1995,12,13))
                .email("podopitniy@gmail.com")
                .build();
    }

    public static CustomerCreateDTO getTestCustomerCreateDto(){
        return CustomerCreateDTO.builder()
                .firstName("Podopitniy")
                .lastName("Chel")
                .birthDate(LocalDate.of(1995,12,13))
                .email("podopitniy@gmail.com")
                .build();
    }

    public static CustomerResponseDTO getTestCustomerResponseDto(){
        return new CustomerResponseDTO(
                20L,
                "Podopitniy",
                "Chel",
                LocalDate.of(1995,12,13),
                "podopitniy@gmail.com"
        );
    }
}