package com.api.carTuning.ServiceImpl;

import com.api.carTuning.TestData;
import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.model.Customer;
import com.api.carTuning.repository.CustomerRepository;
import com.api.carTuning.serviceImpl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;
    private CustomerCreateDTO customerCreateDTO;


    @Test
    void testCreateCustomerSuccess() {
        CustomerCreateDTO dto = TestData.getTestCustomerCreateDto();
        Customer customer = TestData.getTestCustomer();

        when(customerRepository.findCustomerByEmail(dto.getEmail())).thenReturn(Optional.empty());
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        CustomerResponseDTO response = customerService.createCustomer(dto);

        assertNotNull(response);
        assertEquals(customer.getId(), response.getId());
        assertEquals(customer.getFirstName(), response.getFirstName());

        verify(customerRepository, times(1)).findCustomerByEmail(dto.getEmail());
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void testCreateCustomerEmailAlreadyExists(){
        CustomerCreateDTO dto = TestData.getTestCustomerCreateDto();
        Customer existingCustomer = TestData.getTestCustomer();

        when(customerRepository.findCustomerByEmail(dto.getEmail())).thenReturn(Optional.of(existingCustomer));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                customerService.createCustomer(dto));

        assertEquals("Email already exists!", exception.getMessage());

        verify(customerRepository, times(1)).findCustomerByEmail(dto.getEmail());
        verify(customerRepository, never()).save(any(Customer.class));
    }
}
