package com.api.carTuning;

import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.dto.VehicleCreateDTO;
import com.api.carTuning.dto.VehicleResponseDTO;
import com.api.carTuning.model.Customer;
import com.api.carTuning.model.Vehicle;

import java.time.LocalDate;


public class TestData{
    public static Customer getTestCustomer(){
        return  Customer.builder()
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

    public static Vehicle getTestVehicle(){
        return Vehicle.builder()
                .brand("Toyota")
                .horsePower(290)
                .productionYear(2002)
                .customer(getTestCustomer())
                .build();
    }

    public static VehicleCreateDTO getTestVehicleCreateDto(){
        return VehicleCreateDTO.builder()
                .brand("Toyota")
                .horsePower(290)
                .productionYear(2002)
                .customerId(getTestCustomer().getId())
                .build();
    }

    public static VehicleResponseDTO getTestVehicleResponseDto(){
        return  new VehicleResponseDTO(
                30L,
                2002,
                290,
                "Toyota"
        );
    }
}