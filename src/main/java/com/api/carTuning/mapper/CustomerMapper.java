package com.api.carTuning.mapper;

import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.model.Customer;

public class CustomerMapper {
    public static Customer toEntity(CustomerCreateDTO dto){

        return Customer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .build();

    }


    public static CustomerResponseDTO toDto(Customer customer){
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getBirthDate(),
                customer.getEmail()
        );
    }
}
