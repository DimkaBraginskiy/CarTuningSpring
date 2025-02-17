package com.api.carTuning.serviceImpl;

import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.mapper.CustomerMapper;
import com.api.carTuning.model.Customer;
import com.api.carTuning.repository.CustomerRepository;
import com.api.carTuning.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerCreateDTO customerCreateDto) {
        if(customerRepository.findCustomerByEmail(customerCreateDto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists!");
        }

        Customer customer = Customer.builder()
                .firstName(customerCreateDto.getFirstName())
                .lastName(customerCreateDto.getLastName())
                .birthDate(customerCreateDto.getBirthDate())
                .email(customerCreateDto.getEmail())
                .build();

        customerRepository.save(customer);

        return CustomerMapper.toDto(customer);//using Mapper

    }

    @Override
    public CustomerResponseDTO getCutomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return CustomerMapper.toDto(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDto)// converting each customer to dto
                .collect(Collectors.toList());
    }

    @Override
    @Transactional // if error occurs - rolls back
    public void deleteCustomer(Long id) {
        if(!customerRepository.existsById(id)){
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
