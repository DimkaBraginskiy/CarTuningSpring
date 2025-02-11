package com.api.carTuning.service;

import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerCreateDTO customerCreateDto);
    CustomerResponseDTO getCutomerById(Long id);
    List<CustomerResponseDTO> getAllCustomers();
    void deleteCustomer(Long id);

}
