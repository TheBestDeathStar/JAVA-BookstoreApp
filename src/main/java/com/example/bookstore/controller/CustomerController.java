package com.example.bookstore.controller;

import com.example.bookstore.dto.CustomerDto;
import com.example.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(id, customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}