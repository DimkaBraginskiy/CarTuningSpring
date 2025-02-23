package com.api.carTuning.ServiceImpl;

import com.api.carTuning.TestData;
import com.api.carTuning.dto.VehicleCreateDTO;
import com.api.carTuning.dto.VehicleResponseDTO;
import com.api.carTuning.model.Customer;
import com.api.carTuning.model.Vehicle;
import com.api.carTuning.repository.CustomerRepository;
import com.api.carTuning.repository.VehicleRepository;
import com.api.carTuning.serviceImpl.VehicleServiceImpl;
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
public class VehicleServiceImplTest {
    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private VehicleServiceImpl vehicleService;
    
    private Vehicle vehicle;
    private Customer customer;

    @BeforeEach
    void setUp() {
        vehicleService = new VehicleServiceImpl(vehicleRepository, customerRepository);
    }

    @Test
    void testCreateVehicleSuccess(){
        VehicleCreateDTO dto = TestData.getTestVehicleCreateDto();
        Vehicle vehicle = TestData.getTestVehicle();
        Customer customer = TestData.getTestCustomer();

        when(customerRepository.findById(dto.getCustomerId())).thenReturn(Optional.of(customer));
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

        VehicleResponseDTO responseDTO = vehicleService.createVehicle(dto);

        assertNotNull(responseDTO);
        assertEquals(vehicle.getId(), responseDTO.getId());
        assertEquals(vehicle.getBrand(), responseDTO.getBrand());
        assertEquals(vehicle.getHorsePower(), responseDTO.getHorsePower());
        assertEquals(vehicle.getProductionYear(), responseDTO.getProductionYear());

        verify(customerRepository, times(1)).findById(dto.getCustomerId());
        verify(vehicleRepository, times(1)).save(any(Vehicle.class));
    }

    @Test
    void testCreateVehicleCustomerNotFound(){
        VehicleCreateDTO dto = TestData.getTestVehicleCreateDto();
        when(customerRepository.findById(dto.getCustomerId())).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> vehicleService.createVehicle(dto));

        assertEquals("Customer not found", exception.getMessage());

        verify(customerRepository, times(1)).findById(dto.getCustomerId());
        verify(vehicleRepository, never()).save(any(Vehicle.class));
    }

}
