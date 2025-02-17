package com.api.carTuning.controller;

import com.api.carTuning.dto.CustomerCreateDTO;
import com.api.carTuning.dto.CustomerResponseDTO;
import com.api.carTuning.exception.CustomerNotFoundException;
import com.api.carTuning.model.Customer;
import com.api.carTuning.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerCreateDTO customerCreateDTO){
        CustomerResponseDTO responseDTO = customerService.createCustomer(customerCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id){
        CustomerResponseDTO responseDTO = customerService.getCutomerById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
        List<CustomerResponseDTO> responseCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(responseCustomers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Cusomter with ID " + id + " has been successfuly removed.");
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
